import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  build: {
    outDir: 'dist', // Garante que a pasta de saída é a que o Docker espera
  },
  server: {
    proxy: {
      // Quando o frontend chamar '/auth', o Vite redireciona para o Spring local
      '/auth': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      // Mesma coisa para '/parcerias'
      '/parcerias': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      // Dica: Se todos seus endpoints começassem com /api, bastaria uma regra só.
    }
  }
})