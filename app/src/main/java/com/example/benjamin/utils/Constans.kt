package com.example.benjamin.utils

import com.example.benjamin.model.Virtue
import com.example.benjamin.model.VirtueSet

class Constans {
    companion object{
        fun getDefaultVirtueData(): VirtueSet {
            val title = "벤자민의 13가지 덕목"
            val mainVirtueIndex = 0
            val virtue = listOf(
                Virtue(0,"절제","자타에 이익을 주는 말만을 하고, 하찮은 대화는 피하라."),
                Virtue(1,"침묵","자타에 이익을 주는 말만을 하고, 하찮은 대화는 피하라."),
                Virtue(2,"질서","모든 물건은 제자리에 두라. 일은 모두 때를 정해서 하라."),
                Virtue(3,"결단","해야 할 일은 결심하며, 게을리하지 말고 실행하라."),
                Virtue(4,"절약","자타에 이익을 주는 일에 돈을 사용하되, 낭비하지 마라."),
                Virtue(5,"근면","시간을 낭비하지 마라. 유익한 일에 종사하고 무용한 행위는 끊어버려라."),
                Virtue(6,"진실","사람을 속여 헤치지 마라. 모든 언행은 공정하게 하라."),
                Virtue(7,"정의","남에게 해를 주지 않으며 해로운 일을 해서도 안 된다."),
                Virtue(8,"중용","극단을 피하라. 내게 죄가 있다고 생각하거든 남의 비난과 불법을 참으라."),
                Virtue(9,"청결","신체. 의복, 주택에 불결한 흔적을 남기지 마라."),
                Virtue(10,"침착","사소한 일, 보통 있는 일, 피할 수 없는 일에 침착함을 잃지 마라."),
                Virtue(11,"순결","건강과 자손을 위해서만 성교를 하라. 아둔해지거나 허약해지거나 자타의 평화나 평판을 해지치 말라."),
                Virtue(12,"겸손","예수와 소크라테스를 본받으라."),
            )
            return VirtueSet(title=title, mainVirtueIndex = mainVirtueIndex, virtue = virtue)
        }
    }
}