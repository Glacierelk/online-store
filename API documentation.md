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

| 名称                   | 类型      | 是否必须 | 备注                                    |
| ---------------------- | --------- | -------- | --------------------------------------- |
| `flag`                 | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg`             | `string`  | 非必须   | 如果获取失败，返回一个错误信息          |
| `data`                 | `list`    | 必须     | 分类数据列表                            |
| \|- `category_name`    | `string`  | 必须     | 分类名称                                |
| \|- `cid`              | `number`  | 必须     | 分类ID                                  |
| \|- `products`         | `list`    | 必须     | 当前分类的商品                          |
| \|- \|- `id`           | `number`  | 必须     | 商品ID                                  |
| \|- \|- `name`         | `string`  | 必须     | 商品名称                                |
| \|- \|- `subTitle`     | `string`  | 非必需   | 商品小标题                              |
| \|-\|- `originalPrice` | `number`  | 必须     | 原价                                    |
| \|-\|- `promotePrice`  | `number`  | 非必需   | 促销价                                  |
| \|-\|- `stock`         | `number`  | 必须     | 库存                                    |
| \|- \|- `images`       | `list`    | 必须     | 商品图片                                |
| \|- \|- \|- `id`       | `number`  | 必须     | 图片 ID                                 |
| \|- \|- \|- `type`     | `string`  | 必须     | 图片分类                                |

##### 响应数据样例

```json
{
	"flag": true,
	"data": [
		{
			"category_name": "安全座椅",
			"cid": 60,
			"products": [
				{
					"id": 958,
					"name": "惠尔顿儿童安全座椅isofix硬接口汽车用安全坐椅9个月-12岁酷睿宝",
					"subTitle": "双接口固定 夏克立推荐 好评如潮",
					"originalPrice": 2848,
					"promotePrice": 1993.6,
					"stock": 52,
					"cid": 60,
					"createDate": 1469384947000,
					"images": [
						{
							"id": 10144,
							"pid": 0,
							"type": "type_single"
						}
					],
					"properties": null,
					"comments": null
				}
			]
		}
	],
	"errorMsg": null
}
```

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

#### 响应数据

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

### 后台添加商品分类属性

#### 基本信息

> 请求路径：`/property/change`
>
> 请求方式：POST
>
> 接口描述：该接口用于后台新增某个商品分类的属性

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注     |
| ----- | -------- | -------- |--------|
| `id`  | `number` | 必须     | 要修改的属性 |
| `name` | `string` | 必须     | 属性的值   |

##### 请求样例

~~~HTTP
POST http://localhost:8080/store/property/change HTTP/1.1
Content-Type: application/json

{
	"id": 60,
	"name": "好好好"
}
~~~

#### 响应数据

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

### 后台修改商品

#### 基本信息

> 请求路径：`/product/editProduct`
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
POST http://localhost:8080/store/product/editProduct HTTP/1.1
Content-Type: application/json

{
    "id":83,
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

### 根据分类 `cid` 获取商品内容

#### 基本信息

> 请求路径：`/category/searchCategoryProperty`
>
> 请求方式：GET
>
> 接口描述：该接口根据分类cid获取商品内容



#### 请求参数

cid

##### 参数说明

分类ID

##### 请求样例

```http
GET http://localhost:8080/store/category/searchCategoryProperty HTTP/1.1
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称                 | 类型      | 是否必须 | 备注                                    |
| -------------------- | --------- | -------- | --------------------------------------- |
| `flag`               | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg`           | `string`  | 非必须   | 如果获取失败，返回一个错误信息          |
| `data`               | `list`    | 必须     | 分类数据列表                            |
| \| - `category_name` | `string`  | 必须     | 分类名称                                |
| \| - `cid`           | `number`  | 必须     | 分类ID                                  |
| \| - `name`          | `string`  | 必须     | 商品名称                                |
| \| - `subTitle`      | `string`  | 非必需   | 商品小标题                              |
| \| - `originalPrice` | `number`  | 必须     | 原价                                    |
| \| - `promotePrice`  | `number`  | 非必需   | 促销价                                  |
| \| - `stock`         | `number`  | 必须     | 库存                                    |

##### 响应数据样例

```json
{
  "flag": true,
  "data": [
    {
      "id": 87,
      "name": "Konka/康佳 LED32S1卧室32吋安卓智能无线WIFI网络液晶平板电视机",
      "subTitle": "32吋电视机 8核智能 网络 全国联保 送货上门",
      "originalPrice": 1699.0,
      "promotePrice": 1104.35,
      "stock": 98,
      "cid": 83,
      "createDate": 1471077812000
    }
  ],
  "errorMsg": null
}
```

### 后台添加商品图片

#### 基本信息

> 请求路径：`/upload/product`
>
> 请求方式：POST
>
> 接口描述：该接口用于后台添加某个商品的图片

##### 参数说明

| 参数名     | 类型     | 是否必须 | 备注                                        |
| ---------- | -------- | -------- | ------------------------------------------- |
| `filename` | `string` | 必须     | 上传图片的名称                              |
| `type`     | `string` | 必须     | 图片类型，`type_single` 或者 `type_details` |
| `pid`      | `number` | 必须     | 商品 ID                                     |
| `file`     | `object` | 必须     | 待上传的图片                                |

##### 请求样例

```http
POST http://localhost:8080/store/user/register HTTP/1.1
Content-Type: application/json

{
	"file": file,
	"filename": "test.jpg",
	"type": "type_single",
	"pid": 87
}
```

#### 响应数据

##### 参数格式

`application\json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 请求是否成功，`true` 成功，`false` 失败 |
| `errorMsg` | `string`  | 非必须   | 如果上传失败，返回一个错误信息          |
| `data`     | `object`  | 非必需   | 此字段在此接口中未使用                  |

##### 响应数据样例

```json
{
  "flag": true,
  "data": null,
  "errorMsg": null
}
```

## 订单

### 创建订单

#### 基本信息

> 请求路径：`/order/createOrder`
>
> 请求方式：POST
>
> 接口描述：该接口用于创建订单

#### 请求参数

##### 参数说明

| 名称           | 类型     | 是否必须 | 备注                                   |
| -------------- | -------- | -------- | -------------------------------------- |
| `uid`          | `number` | 必须     | 创建订单的用户ID                       |
| `address`      | `string` | 非必须   | 订单的收货地址默认为用户注册的地址信息 |
| `receiverTel`  | `number` | 非必须   | 收货人手机号                           |
| `user_message` | `string` | 非必须   | 用户对该订单的备注                     |
| `orderItems`   | `list`   | 必须     | 订单包含的商品ID与件数                 |
| \|-`pid`       | `number` | 必须     | 购买商品的ID                           |
| \|-`count`     | `number` | 必须     | 购买商品的件数                         |

##### 请求样例

~~~HTTP
POST http://localhost:8080/store/product/search HTTP/1.1
Content-Type: application/json

{
    "uid": 114,
    "receiverTel": "13587168037",
    "userMessage": "好好好",
    "orderItems": [
        {"pid": 87, "count": 3},
        {"pid": 148, "count": 1},
        {"pid": 204, "count": 2}
    ]
}

~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                        |
| ---------- | --------- | -------- | ------------------------------------------- |
| `flag`     | `boolean` | 必须     | 创建订单是否成功，`true` 成功，`false` 失败 |
| `errorMsg` | `string`  | 非必须   | 如果删除失败，返回一个错误信息              |
| `data`     | `object`  | 非必须   | 该参数在该API无效                           |

##### 响应数据样例

~~~json
{
    "flag": true,
    "data": null,
    "errorMsg": null
}
~~~



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
            "id": 1,
            "orderCode": "202306281219233704899",
            "address": null,
            "productCount": 35,
            "totalPrice": 47277.99987792969,
            "post": null,
            "receiver": null,
            "receiverTel": "13587168037",
            "userMessage": "好",
            "createDate": "2023-06-30 09:17:16.0",
            "payDate": "2023-08-30 09:15:21.0",
            "deliveryDate": "2023-09-30 09:15:25.0",
            "confirmDate": "2023-06-24 09:15:10.0",
            "orderItems": null,
            "uid": 1,
            "status": 1
        },
        {
            "id": 2,
            "orderCode": "202306281026465138173",
            "address": null,
            "productCount": 1,
            "totalPrice": 1104.3499755859375,
            "post": null,
            "receiver": null,
            "receiverTel": "13587168038",
            "userMessage": "坏",
            "createDate": "2023-06-30 09:29:22.0",
            "payDate": "2023-06-30 09:29:27.0",
            "deliveryDate": "2023-06-30 09:29:30.0",
            "confirmDate": "2023-06-30 09:29:19.0",
            "orderItems": null,
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

| 参数名 | 类型     | 是否必须 | 备注          |
| ------ | -------- | -------- | ------------- |
| `uid`  | `number` | 必须     | 待查询用户 ID |

##### 请求样例

~~~HTTP
GET http://localhost:8729/store/order/getOrdersByUserId?uid=1 HTTP/1.1
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称                  | 类型        | 是否必须 | 备注                                   |
| --------------------- | ----------- | -------- | -------------------------------------- |
| `flag`                | `boolean`   | 必须     | 请求是否成功，`true`成功，`false`失败` |
| `errorMsg`            | `string`    | 非必须   | 如果请求失败，返回一个错误信息         |
| `data`                | `object`    | 必须     | 包含了用户订单的详细信息               |
| \|-`id`               | `number`    | 必须     | 订单ID                                 |
| \|-`orderCode`        | `string`    | 必须     | 订单的唯一编码                         |
| \|-`receiverTel`      | `number`    | 必须     | 收货人手机号                           |
| \|-`userDessage`      | `string`    | 非必须   | 用户备注                               |
| \|-`createDate`       | `timestamp` | 必须     | 创建订单时间                           |
| \|-`payDate`          | `timestamp` | 非必须   | 订单支付时间                           |
| \|-`deliveryDate`     | `timestamp` | 非必须   | 订单发货时间                           |
| \|-`confirmDate`      | `timestamp` | 非必须   | 订单确认收货时间                       |
| \|-`uid`              | `number`    | 必须     | 创建订单的用户ID                       |
| \|-`status`           | `number`    | 必须     | 订单状态                               |
| \|-`productCount`     | `number`    | 必须     | 订单包含的商品数量                     |
| \|-`totalPrice`       | `number`    | 必须     | 订单的总金额                           |
| \|-`order_item`       | `object`    | 必须     | 订单中包含的商品信息                   |
| \|\|-`id`             | `number`    | 必须     | 订单商品条目的id                       |
| \|\|-`pid`            | `number`    | 必须     | 订单商品的id                           |
| \|\|-`oid`            | `number`    | 必须     | 订单的ID                               |
| \|\|-`name`           | `string`    | 必须     | 商品的名称                             |
| \|\|-`originalPrice`  | `number`    | 必须     | 商品的原始价格                         |
| \|\|-`promotePrice`   | `number`    | 非必须   | 商品的促销价格                         |
| \|\|-`count`          | `number`    | 必须     | 购买商品的数量                         |
| \|\|-`productImage`   | `object`    | 必须     | 商品的图片                             |
| \|\|\|-`id`           | `number`    | 必须     | 图片的ID                               |
| \|\|\|-`pid`          | `number`    | 必须     | 商品的ID                               |
| \|\|\|-`type`         | `string`    | 必须     | 图片的类型                             |
| \|\|\|-`urlPath`      | `string`    | 非必须   | `single`图片的OSS路径                  |
| \|\|\|-`singleMiddle` | `string`    | 非必须   | `singleMiddle`图片的OSS路径            |
| \|\|\|-`singleSmall`  | `string`    | 非必须   | `singleSmall`图片的OSS路径             |

##### 响应数据样例

~~~json
{
    "flag": true,
    "data": [
        {
            "id": 15,
            "orderCode": "202307030924442033156",
            "address": null,
            "productCount": 1,
            "totalPrice": 1216,
            "post": null,
            "receiver": null,
            "receiverTel": null,
            "userMessage": null,
            "createDate": "2023-07-03 09:24:44.0",
            "payDate": "2023-07-03 09:24:52.0",
            "deliveryDate": "2023-07-03 09:24:56.0",
            "confirmDate": "2023-07-03 09:25:00.0",
            "orderItems": [
                {
                    "id": 17,
                    "pid": 960,
                    "oid": 15,
                    "name": "REEBABY儿童安全座椅9个月-12岁宝宝婴儿汽车用坐椅车载 3C认证",
                    "originalPrice": 1280,
                    "promotePrice": 1216,
                    "count": 1,
                    "imageId": 10166
                }
            ],
            "uid": 1,
            "status": 4
        },
        {
            "id": 16,
            "orderCode": "202307030928532314443",
            "address": null,
            "productCount": 10,
            "totalPrice": 11994.000244140625,
            "post": null,
            "receiver": null,
            "receiverTel": null,
            "userMessage": null,
            "createDate": "2023-07-03 09:28:53.0",
            "payDate": "2023-07-03 09:29:01.0",
            "deliveryDate": null,
            "confirmDate": null,
            "orderItems": [
                {
                    "id": 18,
                    "pid": 959,
                    "oid": 16,
                    "name": "好孩子汽车儿童安全座椅goodbaby9个月－12岁宝宝座椅cs668侧碰王",
                    "originalPrice": 1999,
                    "promotePrice": 1199.4,
                    "count": 10,
                    "imageId": 10155
                }
            ],
            "uid": 1,
            "status": 1
        },
        {
            "id": 17,
            "orderCode": "202307031053448934374",
            "address": null,
            "productCount": 1,
            "totalPrice": 1491,
            "post": null,
            "receiver": null,
            "receiverTel": null,
            "userMessage": null,
            "createDate": "2023-07-03 10:53:44.0",
            "payDate": null,
            "deliveryDate": null,
            "confirmDate": null,
            "orderItems": [
                {
                    "id": 19,
                    "pid": 731,
                    "oid": 17,
                    "name": "西服套装男夏季新郎结婚礼服三件套伴郎服薄款西服大码西装男套装",
                    "originalPrice": 1988,
                    "promotePrice": 1491,
                    "count": 1,
                    "imageId": 7648
                }
            ],
            "uid": 1,
            "status": 0
        },
        {
            "id": 18,
            "orderCode": "202307031053530972677",
            "address": null,
            "productCount": 2,
            "totalPrice": 1720.6000061035156,
            "post": null,
            "receiver": null,
            "receiverTel": null,
            "userMessage": null,
            "createDate": "2023-07-03 10:53:53.0",
            "payDate": null,
            "deliveryDate": null,
            "confirmDate": null,
            "orderItems": [
                {
                    "id": 20,
                    "pid": 731,
                    "oid": 18,
                    "name": "西服套装男夏季新郎结婚礼服三件套伴郎服薄款西服大码西装男套装",
                    "originalPrice": 1988,
                    "promotePrice": 1491,
                    "count": 1,
                    "imageId": 7648
                },
                {
                    "id": 21,
                    "pid": 787,
                    "oid": 18,
                    "name": "酷队秋季运动鞋情侣鞋跑步鞋潮男鞋子透气休闲鞋飞织低帮潮鞋系带",
                    "originalPrice": 328,
                    "promotePrice": 229.6,
                    "count": 1,
                    "imageId": 8264
                }
            ],
            "uid": 1,
            "status": 0
        }
    ],
    "errorMsg": null
}
~~~

### 更新订单状态

#### 基本信息

> 请求路径：`/order/updateStatus`
>
> 请求方式：POST
>
> 接口描述：该接口用于更新某个订单的状态

#### 请求参数

##### 参数说明

| 参数名   | 类型     | 是否必须 | 备注             |
| -------- | -------- | -------- | ---------------- |
| `id`     | `number` | 必须     | 待更新订单 ID    |
| `status` | `number` | 必须     | 待更新订单的状态 |

##### 请求样例

~~~HTTP
POST http://localhost:8729/store/order/updateStatus HTTP/1.1
Content-Type: application/json

{
	"id": "1",
	"status":"1"
}
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                       |
| ---------- | --------- | -------- | ------------------------------------------ |
| `flag`     | `boolean` | 必须     | 状态更新是否成功，`true`成功，`false`失败` |
| `errorMsg` | `string`  | 非必须   | 如果请求失败，返回一个错误信息             |
| `data`     | `object`  | 非必须   | 该参数在该API中无效                        |

##### 响应数据样例

~~~json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
~~~

### 删除订单

#### 基本信息

> 请求路径：`/order/deleteOrder`
>
> 请求方式：POST
>
> 接口描述：该接口用于删除某个用户的订单，并删除order_item表中的订单商品

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注          |
| ------ | -------- | -------- | ------------- |
| `id`   | `number` | 必须     | 删除的订单 ID |

##### 请求样例

~~~
POST http://localhost:8729/store/order/deleteOrder HTTP/1.1
Content-Type: application/json

{
	"id": "1"
}
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                   |
| ---------- | --------- | -------- | -------------------------------------- |
| `flag`     | `boolean` | 必须     | 删除是否成功，`true`成功，`false`失败` |
| `errorMsg` | `string`  | 非必须   | 如果请求失败，返回一个错误信息         |
| `data`     | `object`  | 非必须   | 该参数在该API中无效                    |

##### 响应数据样例

~~~json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
~~~

## 购物车

### 获取用户购物车商品数量

#### 基本信息

> 请求路径：`/cart/getCount`
>
> 请求方式：GET
>
> 接口描述：该接口用于查询某个用户的购物车商品数量

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注          |
| ------ | -------- | -------- | ------------- |
| `id`   | `number` | 必须     | 待查询用户 ID |

##### 请求样例

~~~HTTP
GET http://localhost:8729/store/cart/getCount?id=1 HTTP/1.1
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                   |
| ---------- | --------- | -------- | -------------------------------------- |
| `flag`     | `boolean` | 必须     | 请求是否成功，`true`成功，`false`失败` |
| `errorMsg` | `string`  | 非必须   | 如果请求失败，返回一个错误信息         |
| `data`     | `number`  | 必须     | 用户购物车商品数量                     |

##### 响应数据样例

~~~json
{
	"flag": true,
	"data": 2,
	"errorMsg": null
}
~~~



### 获取用户购物车

#### 基本信息

> 请求路径：`/cart/show`
>
> 请求方式：GET
>
> 接口描述：该接口用于查询某个用户的所有订单

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注          |
| ------ | -------- | -------- | ------------- |
| `id`   | `number` | 必须     | 待查询用户 ID |

##### 请求样例

~~~HTTP
GET http://localhost:8729/store/cart/show?id=1 HTTP/1.1
~~~

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 名称                  | 类型        | 是否必须 | 备注                                         |
| --------------------- | ----------- | -------- | -------------------------------------------- |
| `flag`                | `boolean`   | 必须     | 请求是否成功，`true`成功，`false`失败`       |
| `errorMsg`            | `string`    | 非必须   | 如果请求失败，返回一个错误信息               |
| `data`                | `list`      | 必须     | 包含了用户购物车的信息                       |
| \|- `id`              | `number`    | 必须     | 购物车条目 ID                                |
| \|- `pid`             | `number`    | 必须     | 商品 ID                                      |
| \|- `uid`             | `number`    | 必须     | 当前的用户ID                                 |
| \|- `status`          | `number`    | 必须     | 购物车条目状态，这里返回的都是 1，即未删除的 |
| \|- `count`           | `number`    | 必须     | 商品数量                                     |
| \|- `product`         | `object`    | 必须     | 商品信息                                     |
| \|\|- `id`            | `number`    | 必须     | 商品 ID                                      |
| \|\|- `name`          | `string`    | 必须     | 商品名称                                     |
| \|\|- `subTitle`      | `string`    | 非必需   | 商品小标题                                   |
| \|\|- `originalPrice` | `number`    | 必须     | 商品原价                                     |
| \|\|- `promotePrice`  | `number`    | 必须     | 商品促销价                                   |
| \|\|- `stock`         | `number`    | 必须     | 商品库存                                     |
| \|\|- `cid`           | `number`    | 必须     | 商品类型                                     |
| \|\|- `createDate`    | `timestamp` | 必须     | 商品添加时间                                 |
| \|- `imageId`         | `number`    | 必须     | 商品图片 ID                                  |

##### 响应数据样例

~~~json
{
	"flag": true,
	"data": [
		{
			"id": 1,
			"pid": 87,
			"uid": 1,
			"count": 10,
			"status": 1,
			"product": {
				"id": 87,
				"name": "Konka/康佳 LED32S1卧室32吋安卓智能无线WIFI网络液晶平板电视机",
				"subTitle": "32吋电视机 8核智能 网络 全国联保 送货上门",
				"originalPrice": 1699,
				"promotePrice": 1104.35,
				"stock": 98,
				"cid": 83,
				"createDate": 1471077812000
			},
			"imageId": 629
		}
	],
	"errorMsg": null
}
~~~



### 加入商品到购物车中

#### 基本信息

> 请求路径：`/shoppingCart/addGoods`
>
> 请求方式：POST
>
> 接口描述：该接口用于添加某个商品添加到购物车中

#### 请求参数

##### 参数说明

| 参数名 | 类型    | 是否必须 | 备注       |
| ------ | ------- | -------- | ---------- |
| uid    | Integer | 是       | 用户的id   |
| pid    | Integer | 是       | 商品的id   |
| count  | Integer | 是       | 商品的数量 |

##### 请求样例	

```http
POST http://localhost:8729/store/shoppingCart/addGoods HTTP/1.1
Content-Type: application/json 
{
	"pid": "87",
	"uid":"1"
	"count":"10"
}
```

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| `errorMsg`     | `string`  | 非必须 | 如果请求失败，返回一个错误信息 |
| -------------- | --------- | ------ | ------------------------------ |
| `flag`         | `boolean` | 必须   | 请求是否成功                   |
| \|- `errorMsg` | `String`  | 必须   | 请求失败的提示信息             |

##### 响应数据样例

~~~json
{
	"flag": true,
	"errorMsg": null
}
~~~



### 从购物车删除商品

#### 基本信息

> 请求路径：`/cart/deleteGoods`
>
> 请求方式：DELETE
>
> 接口描述：该接口用于从购物车中删除商品

#### 请求参数

##### 参数说明

| 参数名 | 类型     | 是否必须 | 备注         |
| ------ | -------- | -------- | ------------ |
| `id`   | `number` | 是       | 购物车条目ID |

##### 请求样例	

```http
DELETE http://localhost:8729/store/shoppingCart/deleteGoods?id=1 HTTP/1.1
```

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| `errorMsg`     | `string`  | 非必须 | 如果请求失败，返回一个错误信息 |
| -------------- | --------- | ------ | ------------------------------ |
| `flag`         | `boolean` | 必须   | 请求是否成功                   |
| \|- `errorMsg` | `String`  | 必须   | 请求失败的提示信息             |

##### 响应数据样例

~~~json
{
	"flag": true,
	"errorMsg": null
}
~~~



### 从购物车批量删除商品

#### 基本信息

> 请求路径：`/shoppingCart/deleteGoodsByList`
>
> 请求方式：POST
>
> 接口描述：该接口用于添加某个商品添加到购物车中

#### 请求参数

##### 参数说明

| 参数名 | 类型   | 是否必须 | 备注                     |
| ------ | ------ | -------- | ------------------------ |
| `id`   | `list` | 是       | 删除的购物车条目ID的列表 |

##### 请求样例	

```http
POST http://localhost:8729/store/shoppingCart/deleteGoodsByList HTTP/1.1
Content-Type: application/json

{
	"id":[1,2,3]
}
```

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| `errorMsg`     | `string`  | 非必须 | 如果请求失败，返回一个错误信息 |
| -------------- | --------- | ------ | ------------------------------ |
| `flag`         | `boolean` | 必须   | 请求是否成功                   |
| \|- `errorMsg` | `String`  | 必须   | 请求失败的提示信息             |

##### 响应数据样例

~~~json
{
	"flag": true,
	"errorMsg": null
}
~~~



### 更新购物车中商品的数量

#### 基本信息

> 请求路径：`/shoppingCart/alterGoodsNumber`
>
> 请求方式：POST
>
> 接口描述：该接口用于修改购物车中某个商品的数量

#### 请求参数

##### 参数说明

| 参数名  | 类型     | 是否必须 | 备注         |
| ------- | -------- | -------- | ------------ |
| `id`    | `number` | 是       | 购物车记录ID |
| `count` | `number` | 是       | 商品数量     |

##### 请求样例	

```http
POST http://localhost:8729/store/shoppingCart/deleteGoodsByList HTTP/1.1
Content-Type: application/json

{
	"id":87,
	"count":111
}
```

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| `errorMsg`     | `string`  | 非必须 | 如果请求失败，返回一个错误信息 |
| -------------- | --------- | ------ | ------------------------------ |
| `flag`         | `boolean` | 必须   | 请求是否成功                   |
| \|- `errorMsg` | `String`  | 必须   | 请求失败的提示信息             |

##### 响应数据样例

~~~json
{
	"flag": true,
	"errorMsg": null
}
~~~



### 添加商品评价

#### 基本信息

> 请求路径：`/shoppingCart/addComment`
>
> 请求方式：POST
>
> 接口描述：该接口用于修添加商品的评价

#### 请求参数

##### 参数说明

| 参数名    | 类型    | 是否必须 | 备注                   |
| --------- | ------- | -------- | ---------------------- |
| `pid`     | Integer | 是       | 商品id                 |
| `uid`     | Integer | 是       | 用户id                 |
| `content` | String  | 是       | 用户对于商品评价的内容 |

##### 请求样例	

```http
POST http://localhost:8729/store/shoppingCart/addComment HTTP/1.1
Content-Type: application/json

{
	"pid":87,
	"uid":1,
	"content":"商品很好，孩子很喜欢吃"
}
```

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| 参数名     | 类型      | 是否必须 | 备注               |
| ---------- | --------- | -------- | ------------------ |
| `flag`     | `boolean` | 必须     | 请求是否成功       |
| `errorMsg` | `String`  | 必须     | 请求失败的提示信息 |
| `data`     | `object`  | 非必须   | 该参数在该接口无效 |

##### 响应数据样例

~~~json
{
	"flag": true,
	"errorMsg": null,
    "data":null
}
~~~





### 查看商品是否在购物车中

#### 基本信息

> 请求路径：`/shoppingCart/checkCartStatus`
>
> 请求方式：GET
>
> 接口描述：该接口用于查看商品是否在购物车中

#### 请求参数

##### 参数说明

| pid  | Integer | 是   | 商品id |
| ---- | ------- | ---- | ------ |
| uid  | Integer | 是   | 用户id |
| pid  | Integer | 是   | 商品id |

##### 请求样例	

```http
GET http://localhost:8729/store/shoppingCart/checkCartStatus?uid=1&pid=87 HTTP/1.1
```

#### 响应数据

##### 参数格式

`application/json`

##### 参数说明

| `errorMsg`     | `string`  | 非必须 | 如果请求失败，返回一个错误信息 |
| -------------- | --------- | ------ | ------------------------------ |
| `flag`         | `boolean` | 必须   | 请求是否成功                   |
| `data`         | `boolean` | 必须   | 请求到的状态信息               |
| \|- `errorMsg` | `String`  | 必须   | 请求失败的提示信息             |

##### 响应数据样例

~~~json
{
	"flag": true,
	"errorMsg": null,
    "data":"true"
}
~~~





