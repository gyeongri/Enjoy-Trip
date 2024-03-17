<script>
import Card from "./Card.vue"
export default {
  data() {
    return {
       spots: [
        {
          id : 1,
          imgUrl : '@/assets/img/main1.jpg',
          name : "main",
          description : '2023 겨울축제'
        },
        {
          id : 2,
          imgUrl : '@/assets/img/main2.jpg"',
          name : "Eland",
          description : '빛축제'
        },
        {
          id : 3,
          imgUrl : '@/assets/img/main3.jpg',
          name : "LotteWorld",
          description : '축제'
        },
        {
          id : 4,
          imgUrl : '@/assets/img/main4.png"',
          name : "Everland",
          description : 'X-MAS 윈터 판타지'
        }
      ]
    }
  },
  components : { Card }
}
</script>

<template>
  <div class="card-list">
    <Card
      v-for="spot of spots"
      :imgUrl="spot.imgUrl"
      :name="spot.name"
      :description="spot.description"
      :key="spot.id"
    ></Card>
  </div>
</template>

<style>
.card-list{
  display: flex;
  gap : 15px;
}
</style>