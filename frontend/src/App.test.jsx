import '@testing-library/jest-dom/vitest';
import { render, screen, waitFor } from '@testing-library/react';
import { vi, test, expect } from 'vitest';
import App from './App.jsx';

test('renders portal data from API', async () => {
  global.fetch = vi.fn((url) => Promise.resolve({ ok: true, json: () => Promise.resolve(url.includes('announcements') ? [{ id: 1, title: 'Новость', content: 'Текст' }] : url.includes('departments') ? [{ id: 1, name: 'IT', description: 'Инфраструктура' }] : url.includes('employees') ? [{ id: 1, fullName: 'Анна', position: 'CIO', email: 'a@company.local', department: { name: 'IT' } }] : [{ id: 1, title: 'Регламент', category: 'Документы', url: '/doc.pdf' }]) }));
  render(<App />);
  await waitFor(() => expect(screen.getByText('Новость')).toBeInTheDocument());
  expect(screen.getByText('Корпоративный портал')).toBeInTheDocument();
  expect(screen.getByText('Анна')).toBeInTheDocument();
});
