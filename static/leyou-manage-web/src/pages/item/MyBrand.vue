<template>
  <div class="px-5">
    <v-layout>
      <v-flex xs2>
        <v-btn color="success">
          新增品牌
        </v-btn>
      </v-flex>
      <v-spacer/>
      <v-flex xs4>
        <v-text-field label="搜索" hide-details append-icon="search" v-model="key"/>
      </v-flex>
    </v-layout>

    <v-data-table
      :headers="headers"
      :items="brands"
      :pagination.sync="pagination"
      :total-items="totalBrand"
      :loading="loading"
      :rowsPerPageItems="rowsPerPageItems"
      :rowsPerPageText="rowsPerPageText"
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
        <td class="text-xs-center">
          <v-btn flat icon color="success">
            <v-icon>edit</v-icon>
          </v-btn>
          <v-btn flat icon color="error">
            <v-icon>delete</v-icon>
          </v-btn>
        </td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
  export default {
    name: "Mybrand",
    data() {
      return {
        headers: [
          /*表头名称--------value此列内容名称    align对齐方式            sortable此列是否可以排序*/
          {text: "品牌id", value: "id", align: 'center', sortable: true},
          {text: "品牌名称", value: "name", align: 'center', sortable: false},
          {text: "品牌logo", value: "image", align: 'center', sortable: false},
          {text: "品牌首字母", value: "letter", align: 'center', sortable: true},
          {text: "操作", align: 'center', sortable: false}
        ],
        brands: [],
        loading: false,
        pagination: {},
        rowsPerPageItems: [5, 7, 20],
        rowsPerPageText: "每页显示行数",
        totalBrand: 0,
        key: ""    //搜索的条件
      }
    },
    created() {
      //后台查询品牌信息
      this.loadBrands();

    },
    watch: {//监听事件，如果key发生了变化，就调用改方法
      key() {
        this.pagination.page = 1;
        this.loadBrands();
      },
      pagination: {
        deep: true,
        handler() {
          this.loadBrands();
        }
      }
    },
    methods: {
      loadBrands() {
        this.loading = true;
        this.$http.get("/item/brand/page", {
          params: {
            key: this.key,                        //搜索条件
            page: this.pagination.page,           //当前页
            rows: this.pagination.rowsPerPage,    //每页大小
            sortBy: this.pagination.sortBy,        //排序字段
            desc: this.pagination.descending       //排序方式，是否降序
          }
        }).then(response => {
          this.brands = response.data.items;
          this.totalBrand = response.data.total;
          this.loading = false;
        })
      }
    },
  }
</script>

<style scoped>

</style>
