/// <reference types="vitest"/>
/// <reference types="vite/client"/>
/// <reference types="@testing-library/jest-dom" />


import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  test:{
    globals:true,
    environment: "jsdom",
    css:true,
    setupFiles: './src/test/setup.ts',
  },
})
