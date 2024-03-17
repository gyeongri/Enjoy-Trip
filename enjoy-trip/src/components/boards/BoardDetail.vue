<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { detailArticle, deleteArticle, listComment } from "@/api/board";
import CommentListItem from "@/components/boards/item/CommentListItem.vue";
import CommentWrite from "@/components/boards/item/CommentWrite.vue";
const route = useRoute();
const router = useRouter();

// const articleno = ref(route.params.articleno);
const { articleno } = route.params;
const user = JSON.parse(sessionStorage.getItem("user"));
const article = ref({});
const comments = ref([]);
function checkId() {
  if (user) {
    if (user.userNickname == article.value.userNickname) return true;
    else return false;
  } else {
    return false;
  }
}
onMounted(() => {
  getArticle();
  getComment();
});
const getComment = () => {
  console.log(articleno + "번 글의 댓글 얻어오기");
  listComment(
    articleno,
    ({ data }) => {
      comments.value = data;
      // console.log(comments);
    },
    (error) => {
      console.log(error);
    }
  );
};

const getArticle = () => {
  // const { articleno } = route.params;
  console.log(articleno + "번글 얻으러 가자!!!");
  detailArticle(
    articleno,
    ({ data }) => {
      article.value = data;
      // console.log(article);
    },
    (error) => {
      console.error(error);
    }
  );
};

function moveList() {
  router.push({ name: "article-list" });
}

function moveModify() {
  router.push({ name: "article-modify", params: { articleno } });
}

function onDeleteArticle() {
  // const { articleno } = route.params;
  console.log(articleno + "번글 삭제하러 가자!!!");
  deleteArticle(
    articleno,
    (response) => {
      if (response.status == 200) moveList();
    },
    (error) => {
      console.error(error);
    }
  );
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <div class="d-flex align-items-center justify-content-between bg-light p-3">
          <h2 class="m-0">
            <span class="ms-2">{{ article.articleTitle }}</span>
          </h2>
          <div>
            <button type="button" class="btn btn-outline-primary me-2" @click="moveList">
              목록
            </button>
            <button
              type="button"
              class="btn btn-outline-success me-2"
              @click="moveModify"
              v-if="checkId()"
            >
              수정
            </button>
            <button
              type="button"
              class="btn btn-outline-danger"
              @click="onDeleteArticle"
              v-if="checkId()"
            >
              삭제
            </button>
          </div>
        </div>
      </div>
      <div class="col-lg-10 text-start mt-3">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">{{ article.articleTitle }}</h5>
            <p class="card-text text-muted">
              작성자: {{ article.userNickname }} | 등록일: {{ article.articleRegisterTime }} | 조회:
              {{ article.articleHit }}
            </p>
            <hr />
            <div class="card-text text-dark">
              {{ article.articleContent }}
            </div>
          </div>
        </div>
        <div class="mt-4">
          <h4>댓글</h4>
          <CommentListItem v-for="comment in comments" :key="comment.comment_no" :comment="comment">
          </CommentListItem>
          <CommentWrite v-if="user" />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
