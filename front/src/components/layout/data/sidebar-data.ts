import { IconCalendar, IconUsers, IconBook } from '@tabler/icons-react'
import { Command } from 'lucide-react'
import { type SidebarData } from '../types'

export const sidebarData: SidebarData = {
  user: {
    name: 'Henrique GC',
    email: 'henriquegc@gmail.com',
    avatar: '/avatars/shadcn.jpg',
  },
  teams: [
    {
      name: 'Biblioteca',
      logo: Command,
      plan: 'Bibliotecário',
    },
  ],
  navGroups: [
    {
      title: 'Geral',
      items: [
        {
          title: 'Estudantes',
          url: '/students',
          icon: IconUsers,
        },
        {
          title: 'Livros',
          url: '/books',
          icon: IconBook,
        },
      ],
    },
    {
      title: 'Emprestimos',
      items: [
        {
          title: 'Realizar emprestimo',
          url: '/loans',
          icon: IconCalendar,
        },
      ],
    },
  ],
}
