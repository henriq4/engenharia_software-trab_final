import { faker } from '@faker-js/faker'

export const users = Array.from({ length: 4 }, () => {
  return {
    id: faker.string.uuid(),
    createdAt: faker.date.past(),
    updatedAt: faker.date.recent(),
  }
})
