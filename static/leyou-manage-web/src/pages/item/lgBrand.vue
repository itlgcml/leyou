<!--用来测试新版vueUI框架的示例-->
<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="brands"
      :options.sync="options"
      :server-items-length="totalDesserts"
      :loading="loading"
      class="elevation-1"
    >

      <template slot="items" slot-scope="props">
        <td class="text-xs-center">{{ props.item.id }}</td>
        <td class="text-xs-center">{{ props.item.name }}</td>
        <td class="text-xs-center">
          <img v-if="props.item.image" :src="props.item.image" width="130" height="40">
          <span v-else>无</span>
        </td>
        <td class="text-xs-center">{{ props.item.letter }}</td>
      </template>
    </v-data-table>
  </div>


</template>

<script>
  export default {
    name: "Mybrand",
    data(){
      return{
        headers: [
          { text:"品牌id", value:"id", align:'center', sortable: true },
          { text:"品牌名称", value:"name", align:'center', sortable: false },
          { text:"品牌logo", value:"image", align:'center', sortable: false },
          { text:"品牌首字母", value:"letter", align:'center', sortable: true }
        ],
        brands:[],
        loading:true,
        options:{},
        totalDesserts:0,

      }
    },
    created(){
      this.brands = [
        {
          "id": 2032,
          "name": "OPPO",
          "image": "http://img10.360buyimg.com/popshop/jfs/t2119/133/2264148064/4303/b8ab3755/56b2f385N8e4eb051.jpg",
          "letter": "O"
        },
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        },
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
        ,
        {
          "id": 2033,
          "name": "飞利浦（PHILIPS）",
          "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
          "letter": "F"
        }
      ]
    }
  }
</script>


<style scoped>

</style>
