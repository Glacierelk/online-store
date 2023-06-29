# 天猫商城 API 文档

`BaseURL: http://localhost:8080/store` 

## 用户注册

### 基本信息

> 请求路径：`/user/register` 
>
> 请求方式：POST
>
> 接口描述：该接口用于根据注册信息进行用户注册



### 请求参数

#### 参数说明

| 参数名     | 类型     | 是否必须 | 备注         |
| ---------- | -------- | -------- | ------------ |
| `name`     | `string` | 必须     | 用户名       |
| `email`    | `string` | 必须     | 用户邮箱     |
| `address`  | `string` | 必须     | 用户邮寄地址 |
| `password` | `string` | 必须     | 用户密码     |

#### 请求样例

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

### 响应数据

#### 参数格式

`application/json` 

#### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- | -------- | --------------------------------------- |
| `flag`     | `boolean` | 必须     | 注册是否成功，`true` 成功，`false` 失败 |
| `data`     | `object`  | 非必需   | 在注册阶段这个字段无用                  |
| `errorMsg` | `string`  | 非必需   | 如果注册失败，返回一个错误信息          |

#### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

## 用户登录

### 基本信息

> 请求路径： `/user/login`
>
> 请求方式：POST
>
> 接口描述：利用前端用户输入的账号和密码进行

### 请求参数

#### 参数说明

| 参数名     | 类型     | 是否必须 | 备注     |
| ---------- | -------- | -------- | -------- |
| `username` | `string` | 必须     | 用户名   |
| `password` | `string` | 必须     | 用户密码 |

#### 请求样例

~~~http
POST http://localhost:8080/store/user/login HTTP/1.1
Content-Type: application/json

{
	"username":"Zincc",
	"password":"123456",
}
~~~

### 响应数据

#### 参数格式

`application\json`

#### 参数说明

| 名称       | 类型      | 是否必须 | 备注                                    |
| ---------- | --------- |------| --------------------------------------- |
| `flag`     | `boolean` | 必须   | 登录是否成功，`true` 成功，`false` 失败 |
| `data`     | `object`  | 非必须  | 在登录阶段这个字段无用                  |
| `errorMsg` | `string`  | 非必须  | 如果登录失败，返回一个错误信息          |

#### 响应数据样例

```json
{
	"flag": true,
	"data": null,
	"errorMsg": null
}
```

## 首页获取分类信息

### 基本信息

> 请求路径：`/category/homePageCategory` 
>
> 请求方式：GET
>
> 接口描述：该接口用于首页获取分类菜单展示内容



### 请求参数

#### 参数说明

无参数

#### 请求样例

```http
GET http://localhost:8080/store/category/homePageCategory HTTP/1.1
```

### 响应数据

#### 参数格式

`application\json`

#### 参数说明

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

#### 响应数据样例

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
					"originalPrice": 0,
					"promotePrice": 0,
					"stock": 0,
					"cid": 0,
					"createDate": null
				}
			]
		}
	],
	"errorMsg": null
}
```
