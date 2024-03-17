<script setup>
import { ref } from "vue";
// import { useRoute, useRouter } from "vue-router";
// import { getUserProfile } from "@/api/user";
// const route = useRoute();
// const router = useRouter();

// const articleno = ref(route.params.articleno);
const user = JSON.parse(sessionStorage.getItem("user"));

const profile = ref({});
console.log(user);

var i;
var ii = String(Math.floor(Math.random() * (3) + 1));
console.log(ii);
if (user.profileImg == null) {
  i = "../src/assets/img/default_profile_image" + ii + ".png";
}
else {
  i = "../" + user.profileImg.replace('@/', 'src/');
}

// onMounted(() => {
//   userProfile();
// });
// const userProfile = () => {
//   console.log(JSON.stringify(user) + "로그인한 유저의 정보 얻어오기");
//   getUserProfile(
//     user,
//     ({ data }) => {
//       profile.value = data;
//       console.log(user);
//     },
//     (error) => {
//       console.log(error);
//     }
//   );
// };
var profile_image_src = user.profileImg;
console.log(profile_image_src);
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-8">
        <div class="card my-5 shadow-lg christmas-card">
          <div class="card-header christmas-header text-white text-center">
            <h2 class="my-3 py-3">🎅 프로필 🎄</h2>
          </div>
          <div class="card-body christmas-body">
        <div class="card mt-3 m-auto" style="max-width: 700px">
          <div class="row g-0">
            <div class="col-md-4">
              <img :src="i" class="img-fluid rounded-start christmas-image" alt="Christmas Image" style="width: 80%; height: auto;" />
            </div>
            <div class="col-md-8">
              <div class="card-body text-start" style="margin-left: 10px;">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">ID: &emsp;&ensp;&emsp;&emsp; {{ user.userId }}</li>
                  <li class="list-group-item">닉네임: &emsp;&emsp;{{ user.userNickname }}</li>
                  <li class="list-group-item">이메일: &emsp;&emsp;{{ user.email }}@{{user.emailDomain}}</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div>
        <br>
          <button type="button" class="btn-christmas-primary mb-3">수정 🎄</button>
          <button type="button" class="btn btn-christmas-success ms-2 mb-2">비밀번호 변경 🎅</button>
          <button type="button" class="btn-christmas-last ms-2 mb-3">회원 탈퇴 🦌</button>
        </div>
      </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.christmas-image {
  /* // 크리스마스 분위기를 위한 스타일 추가 */
  filter: brightness(90%) contrast(120%) hue-rotate(-20deg);
  border: 4px solid #fff;
  border-radius: 10px;
}

.card {
  border: none;
  border-radius: 20px;
}

.card-header {
  background-color: #a7a7a7; /* 회원탈퇴 회색 */
  border-radius: 20px 20px 0 0;
}

.card-body {
  padding: 20px;
}
.mt-3 {
  margin-top: 20px; /* 버튼과 상단 간격 조절 */
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

.btn-christmas-last {
  background-color: #9b9b9b; /* 회원탈퇴 회색 */
  color: rgb(255, 255, 255);
  border: none;
  border-radius: 20px;
  padding: 10px 20px;
  font-size: 1.2em;
  transition: background-color 0.3s;
}

.btn-christmas-last:hover {
  background-color: #4d4d4d; /* 회원탈퇴 회색 */
  color: rgb(255, 255, 255);
  border: none;
  border-radius: 20px;
  padding: 10px 20px;
  font-size: 1.2em;
  transition: background-color 0.3s;
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