import styled from '@emotion/styled'
interface Props {
    isSelected?:boolean
}
export const OrangeComponent = styled.div`
display:flex;
align-items:center;
background-color:orange;
width:100%;
height:5rem;
padding-left:5rem;
font-size:1.4rem;
margin-bottom:1rem;
margin-top:1rem;
`
export const FlexParent = styled.div`
display:flex;
flex-wrap:wrap;

`
export const ReusableDiv = styled.div<Props>`
display:flex;
border:1px solid black;
cursor:pointer;
padding:1rem;
margin:1rem;
border-color:${props=>props.isSelected?'orange':'black'}


`

