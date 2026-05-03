<template>
  <div class="container">
    <h1>在线抽奖</h1>
    <button @click="draw" :disabled="loading">
      {{ loading ? '抽奖中...' : '开始抽奖' }}
    </button>
    <div v-if="result" class="result">
      <p class="prize">{{ result.prize }}</p>
      <p class="message">{{ result.message }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const loading = ref(false)
const result = ref(null)

async function draw() {
  loading.value = true
  try {
    const res = await fetch('/api/lottery/draw')
    const json = await res.json()
    if (json.code === 0) {
      result.value = json.data
    } else {
      result.value = { prize: '错误', message: json.msg }
    }
  } finally {
    loading.value = false
  }
}
</script>

<style>
body {
  margin: 0;
  font-family: sans-serif;
  background: #f5f5f5;
}
.container {
  max-width: 400px;
  margin: 100px auto;
  text-align: center;
  background: #fff;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 2px 12px rgba(0,0,0,0.1);
}
h1 {
  color: #333;
  margin-bottom: 32px;
}
button {
  padding: 12px 32px;
  font-size: 16px;
  background: #e74c3c;
  color: #fff;
  border: none;
  border-radius: 8px;
  cursor: pointer;
}
button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}
.result {
  margin-top: 32px;
}
.prize {
  font-size: 28px;
  font-weight: bold;
  color: #e74c3c;
  margin: 0 0 8px;
}
.message {
  color: #666;
  margin: 0;
}
</style>
