<template>
 <div class="add">
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
                <el-main>
                    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                             class="form">

                        <el-form-item label="商品名称：" prop="name">
                            <el-input v-model="ruleForm.name">

                            </el-input>
                        </el-form-item>

                        <el-form-item label="价格：" prop="price">
                            <el-input v-model="ruleForm.price">

                            </el-input>
                        </el-form-item>

                        <el-form-item label="数量：" prop="num">
                            <el-input v-model="ruleForm.num">
                            </el-input>
                        </el-form-item>


                        <el-form-item>
                            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                            <el-button @click="resetForm('ruleForm')">重置</el-button>
                        </el-form-item>
                    </el-form>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>


<script>
    export default {
        data() {
            return {
                nowTime: '',
                ruleForm: {
                    name: '',
                    date: '',
                    price: '',
                    num: '',
                },
                rules: {
                    name: [
                        {required: true, message: '商品名不能为空', trigger: 'blur'}
                    ],
                    price: [
                        {required: true, message: '不能为空', trigger: 'blur'}
                    ],
                    num: [
                        {required: true, message: '数量不能为空', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8080/shopping/save', this.ruleForm).then(function (resp) {
                          console.log(resp.data)
                            if (resp.data == "success") {
                                _this.$message('添加成功');

                                // _this.$router.push('/BookManage')
                            }

                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            var date = new Date();
            var seperator1 = "-";
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = year + seperator1 + month + seperator1 + strDate + - +date.getHours() + ":" + date.getMinutes();

            this.ruleForm.date= currentdate;

            console.log(this.ruleForm.date)
        }
    }
</script>

<style>
* {
        margin: 0;
        padding: 0;
    }
.add{
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
.form{
  width: 60%;
}
</style>