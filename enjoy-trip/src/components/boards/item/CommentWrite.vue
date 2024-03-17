<script setup>
import { ref, watch } from "vue";
import { useRoute } from "vue-router";
import { writeComment } from "@/api/board";
import router from "../../../router";
const route = useRoute();
// const router = useRouter();
const { articleno } = route.params;
const user = JSON.parse(sessionStorage.getItem("user"));
const comment = ref({
  articleNo: articleno,
  userId: user.userId,
  commentContent: "",
});
function commentRegist() {
  comment.value.commentContent = commentConent2;
  //   console.log(comment.value);
  if (contentErrMsg.value == "") {
    writeComment(
      comment.value,
      (response) => {
        let msg = "댓글 등록 처리 중 문제가 발생했습니다.";
        if (response.status == 201) msg = "댓글 등록이 완료되었습니다.";
        alert(msg);
        router.go();
      },
      (error) => console.log(error)
    );
  }
}
const commentConent2 = ref("");
const contentErrMsg = ref("");
watch(
  () => commentConent2.value,
  (value) => {
    let len = value.length;
    if (len < 1 || len > 50) {
      contentErrMsg.value = "댓글은 1~50글자입니다.";
    } else contentErrMsg.value = "";
  }
);
</script>

<template>
  <form @submit.prevent="submitComment" class="comment-form">
    <div class="comment-input-group">
      <label for="commentInput">댓글 작성</label>
      <div class="textarea-wrapper">
        <textarea
          id="commentInput"
          v-model="commentConent2"
          rows="3"
          placeholder="댓글을 입력하세요..."
          required
        ></textarea>
        <button type="submit" @click="commentRegist">댓글 작성</button>
      </div>
    </div>
  </form>
</template>

<style scoped>
.comment-input-group {
  margin-bottom: 15px;
}

label {
  margin-bottom: 5px;
}

.textarea-wrapper {
  position: relative;
  width: 100%;
}

textarea {
  width: 100%;
  padding: 8px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
  resize: vertical;
}

button {
  position: absolute;
  right: 10px;
  bottom: 10px;
  height: 40px;
  width: 100px; /* 버튼 크기 조절 가능 */
  border: none;
  border-radius: 5px;
  background-color: #007bff;
  color: white;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #0056b3;
}
</style>
