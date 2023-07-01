# 天猫商城 API 文档

`BaseURL: http://localhost:8080/store` 

## 用户

### 用户注册

#### 基本信息

> 请求路径：`/user/register` 
>
> 请求方式：POST
>
> 接口描述：该接口用于根据注册信息进行用户注册



#### 请求参数

##### 参数说明

| 参数名     | 类型     | 是否必须 | 备注         |
| ---------- | -------- | -------- | ------------ |
| `name`     | `string` | 必须     | 用户名       |
| `email`    | `string` | 必须     | 用户邮箱     |
| `address`  | `string` | 必须     | 用户邮寄地址 |
| `password` | `string` | 必须     | 用户密码     |

##### 请求样例

```http
POST http://localhost:8080/store/user/register HTTP/1.1
Content-Type: application/json

{
	"name": "name",
	"email": "123@456",
	"address": "location",
	"password": "123456"
}
```

#### 响应数据

##### 参数格式

`application/json` 

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 注册是否成功，`true` 成功，`false` 失败 |
| `data`     | `object`  | 非必需   | 在注册阶段这个字段无用                  |
| `errorMsg` | `string`  | 非必需   | 如果注册失败，返回一个错误信息          |

##### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

### 用户登录

#### 基本信息

> 请求路径： `/user/login`
>
> 请求方式：POST
>
> 接口描述：利用前端用户输入的账号和密码进行

#### 请求参数

##### 参数说明

| 参数名     | 类型     | 是否必须 | 备注     |
| ---------- | -------- | -------- | -------- |
| `username` | `string` | 必须     | 用户名   |
| `password` | `string` | 必须     | 用户密码 |

##### 请求样例

~~~http
POST http://localhost:8080/store/user/login HTTP/1.1
Content-Type: application/json

{
	"username":"Zincc",
	"password":"123456",
}
~~~

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- |------| --------------------------------------- |
| `flag`     | `boolean` | 必须   | 登录是否成功，`true` 成功，`false` 失败 |
| `data`     | `object`  | 非必须  | 在登录阶段这个字段无用                  |
| `errorMsg` | `string`  | 非必须  | 如果登录失败，返回一个错误信息          |

##### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

### 获取登录用户信息

#### 基本信息

> 请求路径：`/user/getUser`
>
> 请求方式：GET
>
> 接口描述：该接口用于获取登录用户信息



#### 请求参数

##### 参数说明

无参数

##### 请求样例

~~~http
GET http://localhost:8080/store/user/getUser HTTP/1.1
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                            |
| ---------- | --------- | -------- | ------------------------------- |
| `flag`     | `boolean` | 必须     | 成功获取为`true`，否则为`false` |
| `data`     | `object`  | 非必须   | 该参数在此API无效               |
| `errorMsg` | `string`  | 非必须   | 若出错返回一个错误信息          |

##### 响应数据样例

~~~json
{
    "flag": false,
    "data": null,
    "errorMsg": "获取在线用户信息失败"
}
~~~

### 用户退出

#### 基本信息

> 请求路径：`user/logout`
>
> 请求方式：GET
>
> 接口描述：该接口用于失效服务器端的session，实现用户退出

#### 

#### 请求参数

##### 参数说明

无参数

##### 请求样例

~~~http
GET http://localhost:8080/store/user/logout HTTP/1.1
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                              |
| ---------- | --------- | -------- | --------------------------------- |
| `flag`     | `boolean` | 必须     | 成功获退出为`true`，否则为`false` |
| `data`     | `object`  | 非必须   | 该参数在此API无效                 |
| `errorMsg` | `string`  | 非必须   | 若出错返回一个错误信息            |

##### 响应数据样例

~~~json
{
    "flag": true,
    "data": null,
    "errorMsg": null
}
~~~

## 商品分类

### 首页获取分类信息

#### 基本信息

> 请求路径：`/category/homePageCategory` 
>
> 请求方式：GET
>
> 接口描述：该接口用于首页获取分类菜单展示内容



#### 请求参数

##### 参数说明

无参数

##### 请求样例

```http
GET http://localhost:8080/store/category/homePageCategory HTTP/1.1
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称                | 类型      | 是否必须 | 备注                                    |
| ------------------- | --------- | -------- | --------------------------------------- |
| `flag`              | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg`          | `string`  | 非必须   | 如果获取失败，返回一个错误信息          |
| `data`              | `list`    | 必须     | 分类数据列表                            |
| \|- `category_name` | `string`  | 必须     | 分类名称                                |
| \|- `cid`           | `number`  | 必须     | 分类ID                                  |
| \|- `products`      | `list`    | 必须     | 当前分类的商品                          |
| \|- \|- `id`        | `number`  | 必须     | 商品ID                                  |
| \|- \|- `name`      | `string`  | 必须     | 商品名称                                |
| \|- \|- `subTitle`  | `string`  | 非必需   | 商品小标题                              |
| \|- \|- `images`    | `list`    | 必须     | 商品图片                                |
| \|- \|- \|- `id`    | `number`  | 必须     | 图片 ID                                 |
| \|- \|- \|- `type`  | `string`  | 必须     | 图片分类                                |

##### 响应数据样例

```json
{
	"flag": true,
	"data": [
		{
			"category_name": "冰箱",
			"cid": 76,
			"products": [
				{
					"id": 449,
					"name": "MeiLing/美菱 BCD-560WUCX对开门电冰箱家用冰箱WIFI智能风冷无霜",
					"subTitle": "家用冰箱 WIFI智能 风冷无霜",
					"originalPrice": null,
					"promotePrice": null,
					"stock": 0,
					"cid": 0,
					"createDate": null,
					"images": [
						{
							"id": 4573,
							"pid": 0,
							"type": "type_single"
						}
					]
				}
            ]
		}
	],
	"errorMsg": null
}
```

### 后台获取分类信息

#### 基本信息

> 请求路径：`/category/listAllCategories` 
>
> 请求方式：GET
>
> 接口描述：该接口用于后台获取所有分类信息



#### 请求参数

##### 参数说明

无参数

##### 请求样例

```http
GET http://localhost:8080/store/category/listAllCategories HTTP/1.1
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg` | `string`  | 非必须   | 如果获取失败，返回一个错误信息          |
| `data`     | `list`    | 必须     | 分类数据列表                            |
| \|- `name` | `string`  | 必须     | 分类名称                                |
| \|- `id`   | `number`  | 必须     | 分类ID                                  |

##### 响应数据样例

```json
{
	"flag": true,
	"data": [
		{
			"id": 76,
			"name": "冰箱"
		}
	],
	"errorMsg": null
}
```

### 后台删除分类信息

#### 基本信息

> 请求路径：`/category/delete` 
>
> 请求方式：DELETE
>
> 接口描述：该接口用于后台删除某个分类，该删除是级联删除，会把所有相关内容删掉



#### 请求参数

##### 参数说明

| 参数名       | 类型     | 是否必须 | 备注               |
| ------------ | -------- | -------- | ------------------ |
| `categoryId` | `number` | 必须     | 要删除的商品分类ID |

##### 请求样例

```http
DELETE http://localhost:8080/store/category/delete?categoryId=84
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg` | `string`  | 非必须   | 如果获取失败，返回一个错误信息          |
| `data`     | `object`  | 非必需   | 该参数在此请求中无效                    |

##### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

### 后台添加商品分类

#### 基本信息

> 请求路径：`/category/add` 
>
> 请求方式：POST
>
> 接口描述：该接口用于后台新增一个商品分类



#### 请求参数

##### 参数说明

| 参数名         | 类型     | 是否必须 | 备注                 |
| -------------- | -------- | -------- | -------------------- |
| `categoryName` | `string` | 必须     | 要新增的商品分类名称 |

##### 请求样例

```http
POST http://localhost:8080/store/category/add HTTP/1.1
Content-Type: application/json

{
	"categoryName": "test"
}
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg` | `string`  | 非必须   | 如果添加失败，返回一个错误信息          |
| `data`     | `object`  | 非必需   | 该参数在此请求中无效                    |

##### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

## 商品分类属性

### 后台添加商品分类属性

#### 基本信息

> 请求路径：`/property/add`
>
> 请求方式：POST
>
> 接口描述：该接口用于后台新增某个商品分类的属性

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注                   |
| ------ | -------- | -------- | ---------------------- |
| `cid`  | `number` | 必须     | 要新增属性的商品分类id |
| `name` | `string` | 必须     | 新增的属性名           |

##### 请求样例

~~~HTTP
POST http://localhost:8080/store/property/add HTTP/1.1
Content-Type: application/json

{
	"cid": 60,
	"name": "颜色"
}
~~~

### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 参数名     | 类型      | 是否必须 | 备注                                |
| ---------- | --------- | -------- | ----------------------------------- |
| `flag`     | `boolean` | 必须     | 添加成功返回`true`，否则返回`false` |
| `data`     | `object`  | 非必须   | 该参数在此请求中无效                |
| `errorMsg` | `string`  | 非必须   | 若出错返回错误信息                  |

##### 响应数据样例

~~~json
{
    "flag": true,
    "data": null,
    "errorMsg": null
}
~~~



## 商品

### 后台添加商品

#### 基本信息

> 请求路径：`/product/add` 
>
> 请求方式：POST
>
> 接口描述：该接口用于后台新增一个商品



#### 请求参数

##### 参数说明

| 参数名          | 类型     | 是否必须 | 备注              |
| --------------- | -------- | -------- | ----------------- |
| `name`          | `string` | 必须     | 要新增的商品名称  |
| `subTitle`      | `string` | 非必需   | 商品小标题        |
| `originalPrice` | `number` | 必须     | 商品原价          |
| `stock`         | `number` | 必须     | 商品库存          |
| `promotePrice`  | `number` | 非必需   | 商品活动价        |
| `cid`           | `number` | 必须     | 商品所属的分类 ID |

##### 请求样例

```http
POST http://localhost:8080/store/product/add HTTP/1.1
Content-Type: application/json

{
	"name": "test",
	"originalPrice": 100.0,
	"promotePrice": 89.0,
	"stock": 233,
	"subTitle": "tset",
	"cid": 71
}
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg` | `string`  | 非必须   | 如果添加失败，返回一个错误信息          |
| `data`     | `object`  | 非必需   | 该参数在此请求中无效                    |

##### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

### 后台删除商品

#### 基本信息

> 请求路径：`/product/delete` 
>
> 请求方式：DELETE
>
> 接口描述：该接口用于后台删除某个商品，该删除是级联删除，会把所有相关内容删掉



#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注           |
| ------ | -------- | -------- | -------------- |
| `id`   | `number` | 必须     | 要删除的商品ID |

##### 请求样例

```http
DELETE http://localhost:8080/store/product/delete?id=999
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg` | `string`  | 非必须   | 如果删除失败，返回一个错误信息          |
| `data`     | `object`  | 非必需   | 该参数在此请求中无效                    |

##### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

### 获取商品详情

#### 基本信息

> 请求路径：`/product/details` 
>
> 请求方式：POST
>
> 接口描述：该接口用于前台商品详情页面获取当前商品的详情



#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注                   |
| ------ | -------- | -------- | ---------------------- |
| `id`   | `number` | 必须     | 要查询详细信息的商品ID |

##### 请求样例

```http
POST http://localhost:8080/store/product/details HTTP/1.1
Content-Type: application/json

{
	"id": 87
}
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称                  | 类型        | 是否必须 | 备注                                    |
| --------------------- | ----------- | -------- | --------------------------------------- |
| `flag`                | `boolean`   | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg`            | `string`    | 非必须   | 如果删除失败，返回一个错误信息          |
| `data`                | `object`    | 必需     | 包含了商品的详细信息                    |
| \|- `id`              | `number`    | 必须     | 商品ID                                  |
| \|- `name`            | `string`    | 必须     | 商品名称                                |
| \|- `subTitle`        | `string`    | 非必需   | 商品小标题                              |
| \|- `originalPrice`   | `number`    | 必须     | 商品价格                                |
| \|- `promotePrice`    | `number`    | 非必需   | 商品折扣价格                            |
| \|- `stock`           | `number`    | 必须     | 库存                                    |
| \|- `cid`             | `number`    | 必须     | 商品类型                                |
| \|- `createDate`      | `number`    | 必须     | 商品创建日期                            |
| \|- `images`          | `list`      | 必须     | 商品图片列表                            |
| \|\|- `id`            | `number`    | 必须     | 图片 ID                                 |
| \|\|- `type`          | `string`    | 必须     | 图片类型                                |
| \|- `properties`      | `list`      | 必须     | 属性列表                                |
| \|\|- `id`            | `number`    | 必须     | 属性 ID                                 |
| \|\|- `pid`           | `number`    | 必须     | 商品 ID                                 |
| \|\|- `propertyName`  | `string`    | 必须     | 属性名称                                |
| \|\|- `propertyValue` | `string`    | 必须     | 属性值                                  |
| \|- `comments`        | `list`      | 必须     | 评价列表                                |
| \|\|- `id`            | `number`    | 必须     | 评价 ID                                 |
| \|\|- `content`       | `string`    | 必须     | 评价内容                                |
| \|\|- `uid`           | `number`    | 必须     | 做评价用户 ID                           |
| \|\|- `pid`           | `number`    | 必须     | 被评价商品 ID                           |
| \|\|- `create_date`   | `timestamp` | 必须     | 评价日期                                |
| \|\|- `username`      | `string`    | 必须     | 评价用户名                              |

##### 响应数据样例

```json
{
	"flag": true,
	"data": {
		"id": 87,
		"name": "Konka/康佳 LED32S1卧室32吋安卓智能无线WIFI网络液晶平板电视机",
		"subTitle": "32吋电视机 8核智能 网络 全国联保 送货上门",
		"originalPrice": 1699,
		"promotePrice": 1104.35,
		"stock": 98,
		"cid": 83,
		"createDate": 1471077812000,
		"images": [
			{
				"id": 629,
				"pid": 0,
				"type": "type_single"
			}
		],
		"properties": [
			{
				"id": 716,
				"pid": 87,
				"name": "操作系统",
				"value": "VIDAA"
			}
		],
		"comments": [
			{
				"id": 1,
				"content": "哈哈哈",
				"uid": 30,
				"username": "张三",
				"pid": 87,
				"create_date": "2023-06-29 22:15:46.0"
			}
		]
	},
	"errorMsg": null
}
```

### 商品模糊查询

#### 基本信息

> 请求路径：`/product/search` 
>
> 请求方式：POST
>
> 接口描述：该接口用于前台搜索框搜索商品

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注       |
| ------ | -------- | -------- | ---------- |
| `name` | `string` | 必须     | 待查询名称 |

##### 请求样例

```http
POST http://localhost:8080/store/product/search HTTP/1.1
Content-Type: application/json

{
	"name": "乐"
}
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称                | 类型      | 是否必须 | 备注                                    |
| ------------------- | --------- | -------- | --------------------------------------- |
| `flag`              | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg`          | `string`  | 非必须   | 如果删除失败，返回一个错误信息          |
| `data`              | `list`    | 必需     | 搜索得到的商品列表                      |
| \|- `id`            | `number`  | 必须     | 商品 ID                                 |
| \|- `name`          | `string`  | 必须     | 商品名称                                |
| \|- `subTitle`      | `string`  | 非必需   | 商品小标题                              |
| \|- `originalPrice` | `number`  | 必须     | 商品价格                                |
| \|- `promotePrice`  | `number`  | 非必需   | 商品折扣价格                            |
| \|- `stock`         | `number`  | 必须     | 库存                                    |
| \|- `cid`           | `number`  | 必须     | 商品类型                                |
| \|- `createDate`    | `number`  | 必须     | 商品创建日期                            |
| \|- `images`        | `list`    | 必须     | 商品图片列表                            |
| \|\|- `id`          | `number`  | 必须     | 图片 ID                                 |
| \|\|- `type`        | `string`  | 必须     | 图片类型                                |

##### 响应数据样例

```json
{
	"flag": true,
	"data": [
		{
			"id": 147,
			"name": "乐洁士智能马桶高品质全自动遥控感应一体式智能坐便器座便器",
			"subTitle": "全国联保 清洗烘干 气泡按摩 座圈加热 断电冲水",
			"originalPrice": 8960,
			"promotePrice": 8512,
			"stock": 62,
			"cid": 82,
			"createDate": 1471192641000,
			"images": [
				{
					"id": 1276,
					"pid": 0,
					"type": "type_single"
				}
			],
			"properties": null,
			"comments": null
		}
	],
	"errorMsg": null
}
```

## 订单

### 获取所有订单

#### 基本信息

>请求路径：`/order/getAllOrders`
>
>请求方式：GET
>
>接口描述：该接口用于后台获取所有订单的详情

#### 请求参数

##### 参数说明

无参数

##### 请求样例

~~~HTTP
GET http://localhost:8080/order/getAllOrders HTTP/1.1
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称               | 类型        | 是否必须 | 备注                                   |
| ------------------ | ----------- | -------- | -------------------------------------- |
| `flag`             | `boolean`   | 必须     | 请求是否成功，`true`成功，`false`失败` |
| `errorMsg`         | `string`    | 非必须   | 如果请求失败，返回一个错误信息         |
| `data`             | `object`    | 必须     | 包含了订单的详细信息                   |
| \|-`id`            | `number`    | 必须     | 订单ID                                 |
| \|-`order_code`    | `string`    | 必须     | 订单的唯一编码                         |
| \|-`receiver_tel`  | `number`    | 必须     | 收货人手机号                           |
| \|-`user_message`  | `string`    | 非必须   | 用户备注                               |
| \|-`create_date`   | `timestamp` | 必须     | 创建订单时间                           |
| \|-`pay_date`      | `timestamp` | 非必须   | 订单支付时间                           |
| \|-`delivery_date` | `timestamp` | 非必须   | 订单发货时间                           |
| \|-`confirm_date`  | `timestamp` | 非必须   | 订单确认收货时间                       |
| \|-`uid`           | `number`    | 必须     | 创建订单的用户ID                       |
| \|-`status`        | `number`    | 必须     | 订单状态                               |

##### 响应数据样例

~~~json
{
    "flag": true,
    "data": [
        {
            "id": 0,
            "orderCode": "202306281219233704899",
            "address": null,
            "amount": 0,
            "totalPrice": 47277.99987792969,
            "post": null,
            "receiver": null,
            "receiverTel": "13587168037",
            "userMessage": "好",
            "createDate": "2023-06-30 09:17:16.0",
            "payDate": "2023-08-30 09:15:21.0",
            "deliveryDate": "2023-09-30 09:15:25.0",
            "confirmDate": "2023-06-24 09:15:10.0",
            "uid": 1,
            "status": 1
        },
        {
            "id": 0,
            "orderCode": "202306281026465138173",
            "address": null,
            "amount": 0,
            "totalPrice": 1104.3499755859375,
            "post": null,
            "receiver": null,
            "receiverTel": "13587168038",
            "userMessage": "坏",
            "createDate": "2023-06-30 09:29:22.0",
            "payDate": "2023-06-30 09:29:27.0",
            "deliveryDate": "2023-06-30 09:29:30.0",
            "confirmDate": "2023-06-30 09:29:19.0",
            "uid": 30,
            "status": 3
        }
    ],
    "errorMsg": null
}
~~~

### 获取用户订单

#### 基本信息

> 请求路径：`/order/getOrdersByUserId`
>
> 请求方式：GET
>
> 接口描述：该接口用于查询某个用户的所有订单

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注         |
| ------ | -------- | -------- | ------------ |
| `nid`  | `number` | 必须     | 待查询用户id |

##### 请求样例

~~~HTTP
GET http://localhost:8729/store/order/getOrdersByUserId?uid=1 HTTP/1.1
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称               | 类型        | 是否必须 | 备注                                   |
| ------------------ | ----------- | -------- | -------------------------------------- |
| `flag`             | `boolean`   | 必须     | 请求是否成功，`true`成功，`false`失败` |
| `errorMsg`         | `string`    | 非必须   | 如果请求失败，返回一个错误信息         |
| `data`             | `object`    | 必须     | 包含了用户订单的详细信息               |
| \|-`id`            | `number`    | 必须     | 订单ID                                 |
| \|-`order_code`    | `string`    | 必须     | 订单的唯一编码                         |
| \|-`receiver_tel`  | `number`    | 必须     | 收货人手机号                           |
| \|-`user_message`  | `string`    | 非必须   | 用户备注                               |
| \|-`create_date`   | `timestamp` | 必须     | 创建订单时间                           |
| \|-`pay_date`      | `timestamp` | 非必须   | 订单支付时间                           |
| \|-`delivery_date` | `timestamp` | 非必须   | 订单发货时间                           |
| \|-`confirm_date`  | `timestamp` | 非必须   | 订单确认收货时间                       |
| \|-`uid`           | `number`    | 必须     | 创建订单的用户ID                       |
| \|-`status`        | `number`    | 必须     | 订单状态                               |

##### 响应数据样例

~~~json
{
    "flag": true,
    "data": [
        {
            "id": 1,
            "orderCode": "202306281219233704899",
            "address": null,
            "amount": 2,
            "totalPrice": 47277.99987792969,
            "post": null,
            "receiver": null,
            "receiverTel": "13587168037",
            "userMessage": "好",
            "createDate": "2023-06-30 09:17:16.0",
            "payDate": "2023-08-30 09:15:21.0",
            "deliveryDate": "2023-09-30 09:15:25.0",
            "confirmDate": "2023-06-24 09:15:10.0",
            "uid": 1,
            "status": 1
        }
    ],
    "errorMsg": null
}
~~~

