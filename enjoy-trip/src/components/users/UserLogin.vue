<script setup>
import { ref } from "vue";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";
// import { useMenuStore } from "@/stores/menu";

const router = useRouter();

const memberStore = useMemberStore();

const { isLogin } = storeToRefs(memberStore);
const { userLogin, getUserInfo } = memberStore;
// const { changeMenuState } = useMenuStore();

const loginUser = ref({
  userId: "",
  userPwd: "",
});
function reg() {
  router.push({ name: "user-join" });
}
const login = async () => {
  // console.log("login ing!!!! !!!");
  await userLogin(loginUser.value);
  let token = sessionStorage.getItem("accessToken");
  // console.log("111. ", token);
  // console.log("isLogin: ", isLogin);
  if (isLogin) {
    //go
    // console.log("로그인 성공아닌가???");
    getUserInfo(token);
    //입력한 id 그대로 쓰는 방식이라 안좋음, 나중에 userInfo 가져와서 하는 방식으로 바꾸는게 좋음
    // changeMenuState();
  }
  router.push({ name: "main" });
};
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-8">
        <div class="card my-5 shadow-lg">
          <div class="card-header bg-success text-white text-center">
            <h2 class="my-3 py-3">🎅 로그인 🎄</h2>
          </div>
          <div class="card-body">
            <form>
              <div class="mb-3 text-start">
                <label for="id" class="form-label">아이디 : </label>
                <input
                  type="text"
                  class="form-control"
                  v-model="loginUser.userId"
                  placeholder="아이디..."
                />
              </div>
              <div class="mb-3 text-start">
                <label for="pw" class="form-label">비밀번호 : </label>
                <input
                  type="password"
                  class="form-control"
                  v-model="loginUser.userPwd"
                  @keyup.enter="login"
                  placeholder="비밀번호..."
                />
              </div>
              <div class="col-auto text-center">
                <button type="button" class="btn btn-christmas-primary mb-3" @click="login">
                  로그인 🎅
                </button>
                <button type="button" class="btn btn-christmas-success ms-1 mb-3" @click="reg">
                  회원가입 🎄
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* scoped 키워드를 사용하여 해당 컴포넌트에만 스타일 적용 */

.card {
  border: none;
  border-radius: 20px;
}

.card-header {
  border-radius: 20px 20px 0 0;
}

.card-body {
  padding: 20px;
}
.btn-christmas-primary {
  background-color: #ff6347; /* 크리스마스 빨간색 */
  color: white;
  border: none;
  border-radius: 20px;
  padding: 10px 20px;
  font-size: 1.2em;
  transition: background-color 0.3s;
}

.btn-christmas-primary:hover {
  background-color: #cc4b39; /* 버튼 호버 시 색상 변경 */
}

.btn-christmas-success {
  background-color: #228b22; /* 크리스마스 녹색 */
  color: white;
  border: none;
  border-radius: 20px;
  padding: 10px 20px;
  font-size: 1.2em;
  transition: background-color 0.3s;
}

.btn-christmas-success:hover {
  background-color: #1a661a; /* 버튼 호버 시 색상 변경 */
}
</style>
