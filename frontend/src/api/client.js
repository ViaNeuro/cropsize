const API_BASE = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api';
export async function fetchJson(path) {
  const response = await fetch(`${API_BASE}${path}`);
  if (!response.ok) throw new Error(`API error ${response.status}`);
  return response.json();
}
export async function loadPortalData() {
  const [announcements, departments, employees, documents] = await Promise.all([
    fetchJson('/announcements'), fetchJson('/departments'), fetchJson('/employees'), fetchJson('/documents'),
  ]);
  return { announcements, departments, employees, documents };
}
