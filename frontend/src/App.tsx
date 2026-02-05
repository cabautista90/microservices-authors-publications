import { useEffect, useState } from 'react'
import type { Author } from './types/Author'
import { getAuthors } from './api/authors'

function App() {
  const [authors, setAuthors] = useState<Author[]>([])
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    getAuthors()
      .then(setAuthors)
      .catch(err => setError(err.message))
  }, [])

  return (
    <div>
      <h1>Autores</h1>

      {error && <p>{error}</p>}

      <ul>
        {authors.map(author => (
          <li key={author.id}>
            <strong>{author.name}</strong> – {author.email}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default App