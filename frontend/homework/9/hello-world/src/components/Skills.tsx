import { ISkill } from './api';

interface SkillsProps {
  skills: ISkill[];
}

export function Skills({ skills }: Readonly<SkillsProps>) {
  return (
    <div className='skills'>
      <h2>Skills</h2>
      <ul>
        {skills.map((skill : ISkill) => (
          <li key={skill.id}>{skill.skill}</li>
        ))}
      </ul>
    </div>
  );
}
