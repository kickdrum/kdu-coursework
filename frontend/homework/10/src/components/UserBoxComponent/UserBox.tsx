import { Header } from '../HeaderComponent/Header';
import { Hobbies } from '../HobbiesComponent/Hobbies';
import { Skills } from '../SkillsComponent/Skills';
import './UserBox.css';


interface ISkills {
    "id": number;
    "skill": string;
}

interface IHobbies {
    "id": number;
    "hobby": string;
}

interface IUserData {
    userData: {
        "name": string;
        "fullName": string;
        "qualification": string;
        "skills": ISkills[];
        "hobbies": IHobbies[];
    }
}


export const UserBox = (userData: IUserData) => {

    const { name, fullName, qualification, skills, hobbies } = userData.userData;

    return (
        <div className='mainBox'>
            <Header name={name} fullName={fullName} qualification={qualification} />
            <div className="contentBox">
                <Skills skills={skills} />
                <Hobbies hobbies={hobbies} />
            </div>
        </div>
    )
}
