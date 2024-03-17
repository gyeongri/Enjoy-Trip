<script setup>
import { ref, onMounted } from "vue";
import { listSido, listGugun, listAttractions, listContentTypeId } from "@/api/map";

import VKakaoMap from "@/components/common/VKakaoMap.vue";
import VSelect from "@/components/common/VSelect.vue";

const sidoList = ref([{ text: "시도선택", value: "" }]);
const gugunList = ref([{ text: "구군선택", value: "" }]);
const attractions = ref([]);
const selectAttraction = ref({});
const contentTypeIdList = ref([]);
const param = ref({
  pageNo: 1,
  numOfRows: 20,
  zscode: 0,
});
const par = ref({
  contentTypeId: "",
  sido: "",
  gugun: "",
});

onMounted(() => {
  getContentTypeIdList();
  // getSidoList();
  // getAttractions();
});
const getContentTypeIdList = () => {
  listContentTypeId(
    ({ data }) => {
      let options = [];
      data.forEach((cti) => {
        switch (cti.contentTypeId) {
          case "12":
            options.push({ text: "관광지", value: 12 });
            break;
          case "14":
            options.push({ text: "문화시설", value: 14 });
            break;
          case "15":
            options.push({ text: "축제공연행사", value: 15 });
            break;
          case "25":
            options.push({ text: "여행코스", value: 25 });
            break;
          case "28":
            options.push({ text: "레포츠", value: 28 });
            break;
          case "32":
            options.push({ text: "숙박", value: 32 });
            break;
          case "38":
            options.push({ text: "쇼핑", value: 38 });
            break;
          default:
            options.push({ text: "음식점", value: 39 });
            break;
        }
      });
      contentTypeIdList.value = options;
    },
    (err) => {
      console.log(err);
    }
  );
};
// const getSidoList = () => {
//   listSido(
//     ({ data }) => {
//       let options = [];
//       // console.log("시도옵션");
//       options.push({ text: "시도선택", value: "" });
//       data.forEach((sido) => {
//         options.push({ text: sido.sidoName, value: sido.sidoCode });
//       });
//       sidoList.value = options;
//     },
//     (err) => {
//       console.log(err);
//     }
//   );
// };

const onChangeSido = (val) => {
  listGugun(
    { sido: val },
    ({ data }) => {
      let options = [];
      options.push({ text: "구군선택", value: "" });
      data.forEach((gugun) => {
        options.push({ text: gugun.gugunName, value: gugun.gugunCode });
      });
      par.value.sido = val;
      gugunList.value = options;
    },
    (err) => {
      console.log(err);
    }
  );
};

const onChangeGugun = (val) => {
  param.value.zscode = val;
  par.value.gugun = val;
  getAttractions();
};
const onChangeContent = (val) => {
  listSido(
    { contentTypeId: val },
    ({ data }) => {
      let options = [];
      // console.log(data.value);
      options.push({ text: "시도선택", value: "" });
      data.forEach((sido) => {
        options.push({ text: sido.sidoName, value: sido.sidoCode });
      });
      par.value.contentTypeId = val;
      sidoList.value = options;
    },
    (err) => {
      console.log(err);
    }
  );
};

const getAttractions = () => {
  console.log(par.value);
  listAttractions(
    par.value,
    ({ data }) => {
      attractions.value = data;
    },
    (err) => {
      console.log(err);
    }
  );
};

const viewAttraction = (attraction) => {
  selectAttraction.value = attraction;
};
</script>

<template>

  
  <div class="container text-center mt-3">
    <div class="alert alert-success" role="alert">
      <span class="christmas-text">🚌🗺️ 국내 여행 지도 🗺️🚌 </span>
      <br />
      <span class="christmas-info">지도에서 여행지 관련 정보를 찾아보자!</span>
    </div>
    <div class="row mb-2">
      <div class="col d-flex">
        <VSelect :selectOption="contentTypeIdList" @onKeySelect="onChangeContent" />
        <VSelect :selectOption="sidoList" @onKeySelect="onChangeSido" />
        <VSelect :selectOption="gugunList" @onKeySelect="onChangeGugun" />
      </div>
    </div>
    <VKakaoMap :attList="attractions" :selectAttraction="selectAttraction" />
    <table class="table table-hover">
      <thead>
        <tr class="text-center">
          <th scope="col">관광지명</th>
          <th scope="col">타입</th>
          <th scope="col">주소</th>
          <th scope="col">전화번호</th>
          <!-- <th scope="col">이미지</th> -->
        </tr>
      </thead>
      <tbody>
        <tr
          class="text-center"
          v-for="attraction in attractions"
          :key="attraction.contentId"
          @click="viewAttraction(attraction)"
        >
          <th>{{ attraction.title }}</th>
          <td>{{ attraction.contentTypeId }}</td>
          <td>{{ attraction.addr1 }} {{ attraction.addr2 }}</td>
          <td>{{ attraction.tel }}</td>
          <!-- <td><img v-bind:src="attraction.firstImage" alt="" /></td> -->
        </tr>
      </tbody>
    </table>
  </div>
</template>



<style scoped>
mark.purple {
  background: linear-gradient(to top, #c354ff 20%, transparent 30%);
}
img {
  width: 30%;
  height: 10%;
}

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
