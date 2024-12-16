import { z } from 'zod'

const userSchema = z.object({
  id: z.string(),
})

export type User = z.infer<typeof userSchema>

export const userListSchema = z.array(userSchema)
