import { IHobby } from './api';

interface HobbyProps {
  hobbies: IHobby[];
}


export function Hobbies({ hobbies }: Readonly<HobbyProps>) {
  return (
    <div className='hobbies'>
        <h2>Hobbies</h2>
        <ul>
            {hobbies.map((hobby : IHobby) => (
            <li key={hobby.id}>{hobby.hobby}</li>
            ))}
        </ul>
    </div>
  )
}
