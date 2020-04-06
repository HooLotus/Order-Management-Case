<template>
  <div class="shopping">
   <!-- el-container：构建整个页面框架 -->
	   <el-container class="left">
       <!-- el-aside：构建左侧菜单 -->
            <el-aside class="left1">
              <!-- el-menu：左侧菜单内容 -->
              <!-- :default-openeds：默认展开的菜单，通过index属性进行设置。 -->
              <!-- :default-active：默认选中。 -->
                <el-menu router :default-active="$route.path" :default-openeds="['1', '3']">
                  <!-- el-submenu：可展开的菜单 -->
                  <!-- index：菜单的下标，文本类型，不能是数字类型。 -->
                    <el-submenu index="1">
                      <!-- template：对应el-submenu的菜单名，可以在其设置菜单图标，通过i标签的class属性。 -->
                        <template slot="title">
                            <i class="el-icon-goods"></i>订单管理
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="/Shopping">订单列表</el-menu-item>
                            <el-menu-item index="/Add">新增订单</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-container>
                <el-header class="box1">
                    <img src="../assets/ding.png"/>
		              	<span class="title">订单管理</span>
                </el-header>
                <!-- <el-main>：主要区域容器 -->
                <el-main>
                    <el-table :data="purData"  class="table" border >
                        <el-table-column prop="name" label="品牌" width="280" align='center'></el-table-column>
                        <el-table-column prop="date" label="订单日期" width="300" align='center'></el-table-column>

                        <el-table-column prop="price" label="订单单价" width="300" align='center'></el-table-column>
                        <el-table-column label="购买数量" width="300" align='center'>
                            <template slot-scope="scope1">
                                <el-input-number v-model="scope1.row.num" size="small" @change="handleChange" :min="1"
                                                 :max="10"></el-input-number>
                            </template>
                        </el-table-column>
                        <el-table-column label="操作" width="280" align='center'>
                            <template slot-scope="a">
                                <el-button  type="primary" @click="del(a.row)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-main>
                 <span class="span2" v-show="purData.length>0"
                      style="font-family: Microsoft YaHei">总价：{{sumPrice}}元</span>
            </el-container>
        </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
var padaDate = function (value) {
        return value < 10 ? "0" + value : value;
    };

export default {
  name: 'Shopping',
   data() {
    return {
        purData: [{
            id: 1,
            name: "小米",
            date: "",
            price: "100",
            num: 1
      }]
    };
  },
   computed: {
            sumPrice: function () {
                var sum = 0;
                for (var i = 0; i < this.purData.length; i++) {
                    sum += this.purData[i].price * this.purData[i].num;
                }
                return sum;
            }
        },
  methods: {
            del(index) {
                const _this = this
                axios.delete('http://localhost:8080/shopping/deleteById/'+index.id).then(function (resp) {
                    _this.$message('删除成功');
                    window.location.reload();
                })
            },
            handleChange(value) {
                console.log(value);
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8080/shopping/findAll/0/100').then(function (resp) {
                // console.log(resp.data)
                _this.purData = resp.data.content
            })
        }
}
</script>
<style scoped>
 * {
        margin: 0;
        padding: 0;
    }
.shopping{
    height: 900px;
}
.left{
  height: 100%;
   border: 2px solid #f5f5f5;
}
.left1{
   width: 200px;
   background-color: #eee;
}
.box1 {
	height: 70px;
	background-color: skyblue;
}
.box1 img{
    height: 35px;
    vertical-align: middle;
    margin-left: 10px;
    
}
.title {
	margin-left: 20px;
	color: white;
	line-height: 60px;
	font-size: 25px;
   margin-top: 15px;
    margin-left: 5px;
}
 .table{
  height:770px; 
  width: 95%;
  margin-left: 40px;
  border: 1px solid #eee;
   text-align: center;
   font-size: 23px;
   
}

</style>
