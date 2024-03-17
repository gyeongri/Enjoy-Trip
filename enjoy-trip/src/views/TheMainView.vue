<script>
import { defineComponent } from 'vue'
import { Carousel, Pagination, Slide } from 'vue3-carousel'
import CardList from '@/components/CardList.vue'
import 'vue3-carousel/dist/carousel.css'

export default defineComponent({
  name: 'Autoplay',
  components: {
    Carousel,
    Slide,
    Pagination,
  },
  data() {
    return {
      CardList
    };
  }
})
</script>

<template>
  <div class="main-container">
    <div class="main-content">
      <div class="marquee">
        <div class="track">
          <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active" data-bs-interval="10000">
                <img src="@/assets/img/main1.jpg" class="d-block w-100" alt="..." />
              </div>
              <div class="carousel-item" data-bs-interval="2000">
                <img src="@/assets/img/main2.jpg" class="d-block w-100" alt="..." />
              </div>
              <div class="carousel-item">
                <img src="@/assets/img/main3.jpg" class="d-block w-100" alt="..." />
              </div>
              <div class="carousel-item">
                <img src="@/assets/img/main4.png" class="d-block w-100" alt="..." />
              </div>
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#carouselExampleInterval"
              data-bs-slide="prev"
            >
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#carouselExampleInterval"
              data-bs-slide="next"
            >
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
      </div>
      <!-- Your other content here -->
    </div>
  </div>
</template>

<style scoped>
body {
  overflow-x: hidden;
}

/* Center align the carousel */
.marquee {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 90vh;
}

.track {
  overflow: hidden;
  width: 100%;
}

.carousel-inner img {
 /* max-width: 1000px; /* Set the maximum width to 1000 pixels */
  height: auto;
  margin: auto; /* Center-align the image */
}
</style>