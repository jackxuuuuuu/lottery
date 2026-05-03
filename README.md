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

## 生产环境部署（Linux + Nginx）

### 1. 构建前端

```bash
cd frontend
npm install
npm run build
# 产物在 frontend/dist 目录
```

### 2. 启动后端

```bash
cd backend
mvn package -DskipTests
java -jar target/lottery-*.jar
# 后端在 8080 端口运行
```

### 3. 配置 Nginx

将 `frontend/dist` 目录内容复制到 Nginx 静态文件目录，并使用项目根目录下的 `nginx.conf`：

```bash
# 复制静态文件
cp -r frontend/dist/* /usr/share/nginx/html/

# 复制 nginx 配置
cp nginx.conf /etc/nginx/conf.d/lottery.conf

# 重载 Nginx
nginx -s reload
```

`nginx.conf` 的核心配置：
- `location /` — 服务前端静态文件，支持 Vue Router history 模式
- `location /api/` — 将 `/api/` 请求反向代理到后端 `http://localhost:8080/api/`
