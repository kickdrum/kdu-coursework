interface IInfoProps {
    name: string;
    fullName: string;
    qualification: string;
  }
  
export function Info({ name, fullName, qualification }: Readonly<IInfoProps>) {
    return (
      <div className="info">
        <div>Name: {name}</div>
        <div>Full Name: {fullName}</div>
        <div>Qualification: {qualification}</div>
      </div>
    );
  }