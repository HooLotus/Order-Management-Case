<template>
  <div id="app">
    <div id="nav">
      
    </div>
    <router-view/>
  </div>
</template>
<script>
export default{
  name: 'App',
  methods:{
    toHome(){
      this.$router.push('/shopping')
    },
    toAbout(){
      this.$router.push('/add')
    }
  }
}
</script>
<style>

</style>
