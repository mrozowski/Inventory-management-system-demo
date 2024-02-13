package com.mrozowski.ims.domain


import com.mrozowski.ims.domain.port.InventoryEventPublisher
import com.mrozowski.ims.domain.port.ItemRepository
import spock.lang.Specification
import spock.lang.Subject

class ItemServiceSpec extends Specification {

  private def itemRepository = Mock(ItemRepository)
  private def eventPublisher = Mock(InventoryEventPublisher)
  private def mapper = Mock(CommandMapper)

  @Subject
  private def underTest = new ItemService(itemRepository, eventPublisher, mapper)

  def 'should process event and call publisher'() {
    given:
    def command = Fixtures.createSampleEventSoldCommand()
    def item = Fixtures.createSampleItem()
    def updatedEventCommand = Fixtures.createSampleUpdatedEventCommand()

    when:
    underTest.processInventoryEvent(command)

    then:

    1 * itemRepository.getItemByInternalId(command.internalItemId) >> item
    1 * itemRepository.updateQuantity(item.internalId, item.quantity - command.amount)
  }
}
