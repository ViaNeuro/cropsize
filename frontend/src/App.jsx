import { useEffect, useState } from 'react';
import { loadPortalData } from './api/client';
import './styles.css';

const fallback = { announcements: [], departments: [], employees: [], documents: [] };

export default function App() {
  const [data, setData] = useState(fallback);
  const [error, setError] = useState('');
  useEffect(() => { loadPortalData().then(setData).catch(() => setError('Backend недоступен. Проверьте запуск API в локальной сети.')); }, []);
  return <main className="portal">
    <header className="hero"><div><p>Внутренняя сеть предприятия</p><h1>Корпоративный портал</h1><span>Новости, сотрудники, подразделения и документы в одном месте</span></div><a href="mailto:servicedesk@company.local">Сервис-деск</a></header>
    {error && <section className="alert">{error}</section>}
    <section className="grid">
      <Card title="Новости">{data.announcements.map(a => <article key={a.id}><b>{a.title}</b><p>{a.content}</p></article>)}</Card>
      <Card title="Подразделения">{data.departments.map(d => <article key={d.id}><b>{d.name}</b><p>{d.description}</p></article>)}</Card>
      <Card title="Справочник сотрудников">{data.employees.map(e => <article key={e.id}><b>{e.fullName}</b><p>{e.position} · {e.department?.name}</p><a href={`mailto:${e.email}`}>{e.email}</a></article>)}</Card>
      <Card title="Документы">{data.documents.map(d => <article key={d.id}><b>{d.title}</b><p>{d.category}</p><a href={d.url}>Открыть</a></article>)}</Card>
    </section>
  </main>;
}
function Card({ title, children }) { return <section className="card"><h2>{title}</h2>{children}</section>; }
