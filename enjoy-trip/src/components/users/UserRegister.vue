<script setup>
import { ref, watch } from "vue";
import { useRouter } from "vue-router";
import { userRegist } from "@/api/user.js";
const router = useRouter();
const user = ref({
  userId: "",
  userPwd: "",
  userPwdChk: "",
  userNickname: "",
  email: "",
  emailDomain: "선택",
  gender: "선택",
  profileImg: "",
});
const userId2 = ref("");
const userPwd2 = ref("");
const userPwdChk = ref("");
const userNickname2 = ref("");
const regist = () => {
  user.value.userId = userId2;
  user.value.userPwd = userPwd2;
  user.value.userNickname = userNickname2;
  const obj = user.value;


  var ii = String(Math.floor(Math.random() * (2) + 1));
  user.value.profileImg = "@/assets/img/default_profile_image" + ii + ".png";
  // console.log(idErrMsg.value);
  // console.log(pwdErrMsg.value);
  if (idErrMsg.value == "" && pwdErrMsg.value == "" && user.value.userPwd == user.value.userPwdChk && user.value.userPwd.length >= 4 && user.value.userId.length >= 4) {
    userRegist(
      obj,
      () => {
        console.log(obj);
        router.push({ name: "user-login" });
      },
      (error) => {
        console.log(error);
        alert(pwdErrMsg.value);
      }
    );
    // router.push("/");
  } else {
    alert("양식을 확인해 주세요");
    router.go();
  }
};
const reset = () => {
  userId2.value = "";
  userPwd2.value = "";
  user.value.userPwdChk = "";
  userNickname2.value = "";
  user.value.email = "";
  user.value.emailDomain = "선택";
  user.value.gender = "선택";
};
const idErrMsg = ref("");
const pwdErrMsg = ref("");
watch(
  () => userId2.value,
  (value) => {
    let len = value.length;
    if (len < 3 || len > 15) {
      idErrMsg.value = "입력 양식을 다시 체크해주세요";
      // alert(subjectErrMsg.value);
    } else idErrMsg.value = "";
  },
  { immediate: true }
);
watch(
  () => userPwd2,
  (value) => {
    let len = value.length;
    if (len < 3 || len > 21) {
      pwdErrMsg.value = "입력 양식을 다시 체크해주세요";
      // alert(contentErrMsg.value);
    } else pwdErrMsg.value = "";
  },
  { immediate: true }
);
watch(
  () => user.value,
  (value) => {
    let pwd = value.userPwd;
    let pwdChk = value.userPwdChk;
    if (pwd != pwdChk) {
      pwdErrMsg.value = "비밀번호가 달라요";
      // alert(contentErrMsg.value);
    } else pwdErrMsg.value = "";
  }
);
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-8">
        <div class="card my-5 shadow-lg">
          <div class="card-header bg-danger text-white text-center">
            <h2 class="my-3 py-3">🎄 회원가입 🎁</h2>
          </div>
          <div class="card-body">
            <!-- 여기에 회원가입 폼 내용을 추가합니다. -->
            <form>
              <div class="mb-3">
                <div style="text-align: right">
                  <span style="color: red">*</span>부분은 필수 사항입니다.
                </div>
                <div style="text-align: left">
                <label for="userid" class="form-label"
                  ><span style="color: red">*</span>아이디 (4자~15자) {{ userId2.length }}</label
                >
              </div>
                <input type="text" class="form-control" placeholder="아이디..." v-model="userId2" />
              </div>
              <div class="mb-3">
                <div style="text-align: left">
                <label for="userpwd" class="form-label"
                  ><span style="color: red">*</span>비밀번호 (4자~20자) {{ userPwd2.length }}
                </label>
              </div>
                <input
                  type="password"
                  class="form-control"
                  placeholder="비밀번호..."
                  v-model="userPwd2"
                />
              </div>
              <div class="mb-3">
                <div style="text-align: left">
                <label for="pwdcheck" class="form-label"
                  ><span style="color: red">*</span>비밀번호확인
                </label>
              </div>
                <input
                  type="password"
                  class="form-control"
                  id="pwdcheck"
                  placeholder="비밀번호확인..."
                  v-model="user.userPwdChk"
                />
              </div>
              <div class="mb-3">
                <div style="text-align: left">
                <label for="userNickname" class="form-label"
                  ><span style="color: red">*</span>닉네임
                </label>
              </div>
                <input
                  type="text"
                  class="form-control"
                  placeholder="닉네임..."
                  v-model="userNickname2"
                />
              </div>
              <div class="mb-3">
                <div style="text-align: left">
                <label for="emailid" class="form-label">이메일 </label>
              </div>
                <div class="input-group">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="이메일아이디"
                    v-model="user.email"
                  />
                  <span class="input-group-text">@</span>
                  <select
                    class="form-select"
                    aria-label="이메일 도메인 선택"
                    v-model="user.emailDomain"
                  >
                    <option selected>선택</option>
                    <option value="ssafy.com">싸피</option>
                    <option value="google.com">구글</option>
                    <option value="naver.com">네이버</option>
                    <option value="kakao.com">카카오</option>
                  </select>
                </div>
              </div>
              <div class="mb-3">
                <div style="text-align: left">
                <label for="gender" class="form-label">성별 </label>
              </div>
                <select class="form-select" aria-label="성별 선택" v-model="user.gender">
                  <option selected>선택</option>
                  <option value="M">남자</option>
                  <option value="W">여자</option>
                </select>
              </div>
              <div class="col-auto text-center">
                <button type="button" class="btn btn-christmas-primary mb-3" @click="regist">
                  회원가입 🎅
                </button>
                <button type="button" class="btn btn-christmas-success ms-1 mb-3" @click="reset">
                  초기화 🎄
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
</style>