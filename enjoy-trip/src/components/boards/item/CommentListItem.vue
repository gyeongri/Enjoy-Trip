<script setup>
import { defineProps } from "vue";
import { useRouter } from "vue-router";
import { deleteComment } from "@/api/board";

const props = defineProps({ comment: Object });
const user = JSON.parse(sessionStorage.getItem("user"));
const router = useRouter();
function checkId() {
  if (user) {
    if (user.userNickname === props.comment.userNickname) return true;
    else return false;
  } else {
    return false;
  }
}

function onDeleteComment() {
  console.log(props.comment.commentNo + " 댓글 삭제할래");
  deleteComment(props.comment.commentNo, (response) => {
    let msg = "댓글 삭제 성공";
    if (response.status == 200) alert(msg);
    router.go();
  });
}
// console.log(props.comment);
</script>

<template>
  <div class="comment">
    <div class="user-info">
      <img class="profile-image" src="@/assets/img/ezgif.com-gif-maker.gif" alt="Profile Image" />
      <span class="user-nickname">{{ props.comment.userNickname }}</span>
      <span class="register-time">{{ props.comment.commentRegisterTime }}</span>
      <button v-if="checkId()" @click.prevent="onDeleteComment">삭제</button>
    </div>
    <div class="comment-content">{{ props.comment.commentContent }}</div>
  </div>
</template>

<style scoped>
.comment {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin-bottom: 10px;
}

.user-info {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

.profile-image {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  margin-right: 5px;
}

.user-nickname {
  font-weight: bold;
  margin-right: 5px;
}

.register-time {
  color: #888;
  font-size: 12px;
  flex-grow: 1;
}

.comment-content {
  font-size: 16px;
  margin-bottom: 5px;
}
</style>
