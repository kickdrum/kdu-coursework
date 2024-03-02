export interface IListItem{
    text:string, 
    id:string,
    onRemove:(id:string)=> void
}