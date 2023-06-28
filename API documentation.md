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