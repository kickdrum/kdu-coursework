import { TodoContainer } from './TodoContainer'
import { Provider } from 'react-redux'
import { store } from '../../state/store'

describe('<TodoContainer />', () => {
  it('renders', () => {
    cy.mount(<Provider store={store}><TodoContainer /></Provider>)
  })
})