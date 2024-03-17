<script setup>
defineProps({ article: Object });
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ article.articleNo }}</th>
    <td class="text-start">
      <router-link
        :to="{ name: 'article-view', params: { articleno: article.articleNo } }"
        class="article-title link-dark"
      >
        {{ article.articleTitle }}
      </router-link>
    </td>
    <td>{{ article.userNickname }}</td>
    <td>{{ article.articleHit }}</td>
    <td>{{ article.articleRegisterTime }}</td>
  </tr>
</template>

<style scoped></style>
