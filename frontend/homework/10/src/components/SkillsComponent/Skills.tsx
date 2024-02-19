import './Skills.css';

interface ISkills {
    "id": number;
    "skill": string;
}

interface ISkillsProp{
    skills: ISkills[]
}


export const Skills = ({skills}: ISkillsProp) => {
  return (
    <div className='skillsBox'>
        <h4>Skills</h4>
        <ul>
            {skills.map((curr)=>{
                return(
                    <li key={curr.id}>{curr.skill}</li>
                )
            })}
        </ul>
    </div>
  )
}
