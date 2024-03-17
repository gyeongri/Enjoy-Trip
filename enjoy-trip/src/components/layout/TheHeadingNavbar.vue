<script setup>
// import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";
import { storeToRefs } from "pinia";
import { withdrawal } from "@/api/user";
import router from "../../router";

const memberStore = useMemberStore();
const { isLogin } = storeToRefs(memberStore);
// const router = useRouter();
const { userLogout } = memberStore;
const ulogout = () => {
  userLogout();
  sessionStorage.removeItem("user");
};
function redirectToWithdraw() {
  if (isLogin) {
    const user = JSON.parse(sessionStorage.getItem("user"));
    console.log(user.userId + "탈퇴");
    withdrawal(
      user.userId,
      () => {
        console.log("성공");
        router.push({ name: "main" });
      },
      (error) => {
        console.log(error);
      }
    );
    userLogout();
  }
}
</script>

<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top winter-nav">
    <div class="container-fluid">
      <router-link :to="{ name: 'main' }" class="navbar-brand">
        <img src="@/assets/img/logo2.gif" class="winter-logo rounded mx-auto d-block" alt="Logo" />
      </router-link>
      <button
        class="navbar-toggler winter-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarScroll"
        aria-controls="navbarScroll"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll winter-nav-items"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item">
            <router-link :to="{ name: 'attraction' }" class="nav-link">관광지 지도</router-link>
          </li>
          <li class="nav-item">
            <router-link :to="{ name: 'board' }" class="nav-link">여행 게시판</router-link>
          </li>
          <li class="nav-item">
            <router-link :to="{ name: 'plan' }" class="nav-link">여행 계획</router-link>
          </li>
        </ul>

        <div class="marquee">
          <div class="track">
            <div class="content">
              <span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;🎄미리&nbsp;메리&nbsp;크리스마스!🎅</span>
              <!-- 수정: 콘텐츠가 나타나도록 수정 -->
            </div>
          </div>
        </div>

        <ul
          class="navbar-nav ms-auto my-2 my-lg-0 navbar-nav-scroll winter-nav-items"
          style="--bs-scroll-height: 100px"
        >
          <span></span>
          <template v-if="isLogin">
            <li class="nav-item">
              <router-link :to="{ name: 'user-mypage' }" class="nav-link winter-nav-link"
                >마이 페이지</router-link
              >
            </li>
            <li class="nav-item">
              <button @click="ulogout" class="btn nav-link winter-nav-link">로그아웃</button>
            </li>
            <li class="nav-item">
              <button @click="redirectToWithdraw" class="btn nav-link winter-nav-link">
                회원 탈퇴
              </button>
            </li>
          </template>
          <template v-else>
            <li class="nav-item">
              <router-link :to="{ name: 'user-join' }" class="nav-link winter-nav-link"
                >회원가입</router-link
              >
            </li>
            <li class="nav-item">
              <router-link :to="{ name: 'user-login' }" class="nav-link winter-nav-link"
                >로그인</router-link
              >
            </li>
          </template>
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped>
/* Navbar Styles */
.winter-nav {
  background-color: #cde2ff; /* 파란색 배경 */
}

/* Winter Logo */
.winter-logo {
  width: 80px; /* 이미지 너비 */
  height: 80px; /* 이미지 높이 */
}

/* Toggler Icon */
.winter-toggler {
  background-color: #ffffff; /* 토글러 아이콘 색상 */
  border: none;
}

/* Navbar Links Styles */
.winter-nav-items .nav-link {
  color: #215b8a; /* 링크 텍스트 색상 */
  font-weight: bold; /* 폰트 굵기 */
}

/* Hover Effect on Links */
.winter-nav-items .nav-link:hover {
  color: #0f3f5f; /* 링크 호버 시 색상 */
}

/* Winter Nav Link Styles */
.winter-nav-link {
  color: #d62828; /* 특별한 링크 색상 */
  font-weight: bold; /* 폰트 굵기 */
}

/* Winter Nav Link Hover */
.winter-nav-link:hover {
  color: #801a1a; /* 특별한 링크 호버 시 색상 */
}

.marquee {
  /* 설정하고 싶은 너비와 높이 설정 */
  height: 25px;
  width: 800px; /* 변경된 너비 */

  /* 스타일링 */
  overflow: hidden;
  white-space: nowrap;
}

.marquee .track {
  display: inline-block;
  width: 200%;
  animation: marquee 20s linear infinite;
  display: flex;
}

.marquee .content {
  float: left;
  width: 50%;
  padding-right: 10px;
  white-space: nowrap;
}
.marquee .content span {
  animation: marqueeText 20s linear infinite; /* 추가: 텍스트 애니메이션 적용 */
}
@keyframes marquee {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(-100%);
  }
}
</style>
