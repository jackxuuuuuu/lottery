# 抽奖微信小程序

本目录包含复用后端接口的微信小程序前端代码。

## 快速开始

### 1. 填写 AppID

打开 `project.config.json`，将 `appid` 字段的值 `"your-appid-here"` 替换为你在
[微信公众平台](https://mp.weixin.qq.com) → **开发管理 → 开发设置** 中获取到的小程序 AppID。

### 2. 配置后端地址

打开 `app.js`，将 `apiBaseUrl` 替换为你实际部署的后端服务器地址，例如：

```js
apiBaseUrl: 'https://api.yourdomain.com'
```

同时需要在微信公众平台 → **开发管理 → 开发设置 → 服务器域名** 中将该域名添加到
**request 合法域名** 白名单。

### 3. 使用微信开发者工具导入项目

打开 [微信开发者工具](https://developers.weixin.qq.com/miniprogram/dev/devtools/download.html)，
选择 **导入项目**，目录选择本 `miniprogram/` 文件夹，填入 AppID 后即可调试和预览。

## 接口说明

小程序直接复用后端 `/api/lottery/draw` 接口，响应格式统一为：

```json
{
  "code": 0,
  "msg": "success",
  "data": {
    "prize": "一等奖",
    "message": "恭喜你抽中了一等奖！"
  },
  "timestamp": 1714000000000
}
```

`code` 为 `0` 表示成功，非 `0` 表示错误，此时 `msg` 包含错误信息。
