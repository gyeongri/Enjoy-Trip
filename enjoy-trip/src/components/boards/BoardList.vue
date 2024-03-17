<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { listArticle } from "@/api/board.js";

import VSelect from "@/components/common/VSelect.vue";
import BoardListItem from "@/components/boards/item/BoardListItem.vue";
import VPageNavigation from "@/components/common/VPageNavigation.vue";

const router = useRouter();

const selectOption = ref([
  { text: "검색조건", value: "" },
  { text: "글번호", value: "article_no" },
  { text: "제목", value: "article_title" }, //article_title
  { text: "작성자닉네임", value: "user_nickname" },
]);

const articles = ref([]);
const currentPage = ref(1);
const totalPage = ref(0);
const { VITE_ARTICLE_LIST_SIZE } = import.meta.env;
const param = ref({
  pgno: currentPage.value,
  spp: VITE_ARTICLE_LIST_SIZE,
  key: "",
  word: "",
});

onMounted(() => {
  getArticleList();
});

const changeKey = (val) => {
  console.log("BoarList에서 선택한 조건 : " + val);
  param.value.key = val;
};

const getArticleList = () => {
  console.log("서버에서 글목록 얻어오자!!!", param.value);
  listArticle(
    param.value,
    ({ data }) => {
      console.log("페이지 수" + data.value);
      articles.value = data.articles;
      currentPage.value = data.currentPage;
      totalPage.value = data.totalPageCount;
    },
    (error) => {
      console.error(error);
    }
  );
};

const onPageChange = (val) => {
  console.log(val + "번 페이지로 이동 준비 끝!!!");
  currentPage.value = val;
  param.value.pgno = val;
  getArticleList();
};

const moveWrite = () => {
  router.push({ name: "article-write" });
};
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글목록</mark>
        </h2>
      </div>
      <div class="col-lg-10">
        <div class="row align-self-center mb-2">
          <div class="col-md-2 text-start">
            <button type="button" class="btn btn-outline-primary btn-sm" @click="moveWrite">
              글쓰기
            </button>
          </div>
          <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :selectOption="selectOption" @onKeySelect="changeKey" />
              <div class="input-group input-group-sm ms-1">
                <input
                  type="text"
                  class="form-control"
                  v-model="param.word"
                  placeholder="검색어..."
                />
                <button class="btn btn-dark" type="button" @click="getArticleList">검색</button>
              </div>
            </form>
          </div>
        </div>
        <table class="table table-hover">
          <thead>
            <tr class="text-center">
              <th scope="col">글번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">조회수</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>
          <tbody>
            <BoardListItem
              v-for="article in articles"
              :key="article.articleNo"
              :article="article"
            ></BoardListItem>
          </tbody>
        </table>
      </div>
      <VPageNavigation
        :current-page="currentPage"
        :total-page="totalPage"
        @pageChange="onPageChange"
      ></VPageNavigation>
    </div>
  </div>
</template>

<style scoped>
.container {
  padding-top: 20px;
  background-color: #f0f5fe; /* 연한 파란색 배경 */
}

.mark-sky {
  color: #0d6efd; /* 하늘색 텍스트 */
  font-weight: bold; /* 폰트 굵기 */
}

.btn-outline-primary {
  color: #0d6efd; /* 버튼 텍스트 색상 */
  border-color: #0d6efd; /* 버튼 테두리 색상 */
}

.btn-outline-primary:hover {
  background-color: #0d6efd; /* 버튼 호버 시 배경색상 */
  color: #fff; /* 버튼 호버 시 텍스트 색상 */
}

.btn-dark {
  background-color: #0d6efd; /* 검색 버튼 배경색상 */
  border-color: #0d6efd; /* 검색 버튼 테두리 색상 */
}

.btn-dark:hover {
  background-color: #1d99f3; /* 검색 버튼 호버 시 배경색상 */
  border-color: #1d99f3; /* 검색 버튼 호버 시 테두리 색상 */
}

.table {
  background-color: #fff; /* 테이블 배경색상 */
}

.table-hover tbody tr:hover {
  background-color: #eaf6ff; /* 테이블 로우 호버 시 배경색상 */
}
</style>
