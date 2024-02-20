export interface ISkill {
    id: number;
    skill: string;
}

export interface IHobby {
    id: number;
    hobby: string;
}

export interface IPayload {
    name: string;
    fullName: string;
    qualification: string;
    skills: ISkill[];
    hobbies: IHobby[];
}

export async function fetchPayload(): Promise<IPayload> {

    const predefinedPayload: IPayload = {
        name: "Amey",
        fullName: "Amey Aditya",
        qualification: "SSE",
        skills: [
            { id: 1, skill: "Python" },
            { id: 2, skill: "React" }
        ],
        hobbies: [
            { id: 1, hobby: "Cricket" }
        ]
    };

    return predefinedPayload;
}
