# 在线抽奖

一个最简单的前后端分离在线抽奖项目。

## 技术栈

- 前端：Vue 3 + Vite（端口 5173）
- 后端：Spring Boot 2.x，JDK 8（端口 8080）

## 项目结构

```
lottery/
  backend/    # Spring Boot 后端
  frontend/   # Vue 3 + Vite 前端
  README.md
```

## 运行说明

### 后端

```bash
cd backend
mvn spring-boot:run
```

后端启动后监听 `http://localhost:8080`，提供接口：

```
GET /api/lottery/draw
```

示例响应：

```json
{
  "code": 0,
  "prize": "一等奖",
  "message": "恭喜你抽中了一等奖！",
  "timestamp": 1714000000000
}
```

### 前端

```bash
cd frontend
npm install
npm run dev
```

前端启动后访问 `http://localhost:5173`。

> 前端通过 Vite proxy 将 `/api` 请求转发到 `http://localhost:8080`，无需手动配置跨域，开发体验更佳。
