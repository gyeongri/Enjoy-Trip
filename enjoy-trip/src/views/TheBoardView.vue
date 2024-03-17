<template>
  <div class="container text-center mt-3">
    <div class="alert alert-danger" role="alert">
      <span class="christmas-text">🎄 메리 크리스마스! 🎅</span>
      <br />
      <span class="christmas-info">자유롭게 글쓰는 공간</span>
    </div>
    <router-view></router-view>
  </div>
</template>

<style scoped>
.christmas-text {
  font-size: 24px;
  color: #d62828; /* 빨간색 텍스트 */
  font-weight: bold;
}

.christmas-info {
  font-size: 18px;
  color: #0d6efd; /* 파란색 텍스트 */
  font-weight: bold;
}
</style>
