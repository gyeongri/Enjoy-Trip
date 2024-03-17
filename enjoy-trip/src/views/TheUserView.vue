<template>
  <div class="container text-center mt-3">
    <div class="snowflakes" aria-hidden="true">
      <!-- 여러 개의 눈꽃 요소 -->
      <div class="snowflake">❅</div>
      <div class="snowflake">❆</div>
      <div class="snowflake">❅</div>
      <div class="snowflake">❆</div>
      <!-- 필요한 만큼 눈꽃 요소 추가 -->
    </div>
    <div class="announcement-stream">
      <!-- 공지사항 스트림 -->
      <div v-for="(notice, index) in notices" :key="index" class="notice">{{ notice }}</div>
    </div>
    <router-view></router-view>
  </div>
</template>

<style scoped>
/* scoped 키워드를 사용하여 해당 컴포넌트에만 스타일 적용 */

/* 공지사항 스트림을 위한 스타일 */
.announcement-stream {
  display: flex;
  flex-direction: row;
  overflow: hidden;
}

.notice {
  padding: 10px;
  margin-right: 20px;
  white-space: nowrap;
  animation: marquee 20s linear infinite;
}

/* 공지사항 스트림 애니메이션 */
@keyframes marquee {
  0% {
    transform: translateX(100%);
  }
  100% {
    transform: translateX(-100%);
  }
}

/* 눈꽃 애니메이션을 위한 스타일 */
.snowflakes {
  position: fixed;
  top: 0;
  left: 0;
  pointer-events: none;
  z-index: 1000;
}

.snowflake {
  position: absolute;
  color: #fff;
  font-size: 20px;
  animation: snowflakes-fall linear infinite;
  transform-origin: 0 0;
}

/* 눈 내리는 애니메이션 */
@keyframes snowflakes-fall {
  0% {
    transform: translateY(-100vh);
  }
  100% {
    transform: translateY(100vh);
  }
}
</style>

<script setup>
import { ref } from "vue";

// 공지사항 데이터
const notices = ref([]);
</script>
