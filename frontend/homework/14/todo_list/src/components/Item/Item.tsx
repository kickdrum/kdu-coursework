import React from 'react'
import RemoveItemButton from '../RemoveItemButton/RemoveItemButton'
import './Item.scss'

export interface PropItem {
  todoContent: string;
}

const Item:React.FC<PropItem> = (props: PropItem) => {

  return (
    <div className='item-container'>
      <p className='todo-content'>{props.todoContent}</p>
      <RemoveItemButton todoContent={props.todoContent}/>
    </div>
  )
}

export default Item