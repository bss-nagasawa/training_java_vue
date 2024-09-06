<template>
  <div>
    <h1>{{ message }}</h1>
  </div>
</template>

<script>
export default {
  name: "UserLogin",
  data() {
    return {
      message: "",
    };
  },
  mounted() {
    fetch("/api/message")
      .then((response) => response.text())
      .then((data) => {
        this.message = data;
        console.log("data", data);
      });
  },
};
</script>

<style scoped>
h1 {
  color: #42b983;
}
</style>
