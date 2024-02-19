import './Header.css';

interface IHeaderProps{
    name: string,
    fullName: string;
    qualification: string;
}

export const Header = ({name, fullName, qualification}: IHeaderProps) => {
  return (
    <div className='headerBox'>
        <p>{name}</p>
        <p>{fullName}</p>
        <p>{qualification}</p>
    </div>
  )
}
