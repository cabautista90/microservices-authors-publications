import type { Author } from '../types/Author'

const AUTHORS_API = 'http://localhost:8081/api/authors'

export const getAuthors = async (): Promise<Author[]> => {
  const response = await fetch(AUTHORS_API)

  if (!response.ok) {
    throw new Error(`Error ${response.status}`)
  }

  return response.json()
}