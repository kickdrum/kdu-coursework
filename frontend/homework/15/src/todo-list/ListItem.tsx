import "./ListItem.scss";

interface ListItemProps {
    text: string;
    onDelete: () => void;
}

export function ListItem({ text, onDelete }: ListItemProps) {
    return (
        <li className="list-item">
            <span>{text}</span>
            <button className="btn-dlt" onClick={onDelete}>X</button>
        </li>
    );
}
