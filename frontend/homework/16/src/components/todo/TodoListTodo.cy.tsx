import { Todo } from './TodoList'
import { Provider } from 'react-redux'
import { store } from '../../redux/store'

describe('<Todo />', () => {
  it('renders', () => {
    // see: https://on.cypress.io/mounting-react
    cy.mount(<Provider store={store}><Todo /></Provider>)
  })
})