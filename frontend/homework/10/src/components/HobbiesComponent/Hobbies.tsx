import './Hobbies.css';

interface IHobbies {
    "id": number;
    "hobby": string;
}


interface IHobbiesProps{
    hobbies: IHobbies[];
}


export const Hobbies = ({hobbies}: IHobbiesProps) => {
  return (
    <div className='hobbiesBox'>
        <h4>Hobbies</h4>
        <ul>
            {hobbies.map((curr)=>{
                return(
                    <li key={curr.id}>{curr.hobby}</li>
                )
            })}
        </ul>
    </div>
  )
}
