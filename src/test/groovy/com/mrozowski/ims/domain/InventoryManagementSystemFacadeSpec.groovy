package com.mrozowski.ims.domain

import spock.lang.Specification

class InventoryManagementSystemFacadeSpec extends Specification {

  private def itemService = Mock(ItemService)
  private def underTest = new InventoryManagementSystemFacade(itemService)

  def 'should process event'() {
    given:
    def command = Fixtures.createSampleEventSoldCommand()

    when:
    underTest.processInventoryEvent(command)

    then:
    noExceptionThrown()
  }
}
